package com.quiz.controller.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.quiz.model.QuizPageNumberOfTriviaModel;
import com.quiz.controller.quiz.model.QuizPagePlayerAnswers;
import com.quiz.controller.quiz.model.QuizPagePlayerModel;
import com.quiz.domain.player.Player;
import com.quiz.service.IQuizService;

@Controller
public class QuizController {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuizController.class);

    private static final String GET_MAPPING_QUIZ_WITH_PLAYER_UUID_PATH_VARIABLE = "/quiz/{playerUuid}";

    private static final String VIEW_QUIZ = "quiz";

    private IQuizService quizService;

    private Player player;

    @Autowired
    QuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping(GET_MAPPING_QUIZ_WITH_PLAYER_UUID_PATH_VARIABLE)
    public ModelAndView showQuizPage(@PathVariable("playerUuid") String playerUuid) {
        LOGGER.info("{} - Showing Quiz page, playerUUID: {}", this.getClass().getSimpleName(), playerUuid);
        ModelAndView modelAndView = new ModelAndView(VIEW_QUIZ);
        player = quizService.findPlayerByUUID(playerUuid);

        modelAndView.addObject("quizPageNumberOfTriviaModel", new QuizPageNumberOfTriviaModel());
        modelAndView.addObject("quizPagePlayerModel", new QuizPagePlayerModel(player.getUuid(), player.getName()));

        return modelAndView;
    }

    @PostMapping("/getTrivia")
    public ModelAndView showPageWithTrivia(@ModelAttribute("quizPageNumberOfTriviaModel") QuizPageNumberOfTriviaModel quizPageNumberOfTriviaModel) {
        LOGGER.info("{} - Showing Quiz page with {} trivia", this.getClass().getSimpleName(), quizPageNumberOfTriviaModel.getNumberOfTrivia());
        ModelAndView modelAndView = new ModelAndView(VIEW_QUIZ);

        modelAndView.addObject("quizPagePlayerAnswers", new QuizPagePlayerAnswers());
        modelAndView.addObject("quizPagePlayerModel", new QuizPagePlayerModel(player.getUuid(), player.getName(),
                quizService.getQuizPageTriviaModels(quizPageNumberOfTriviaModel.getNumberOfTrivia())));

        return modelAndView;
    }

    @PostMapping("/getAnswers")
    public String getAnswers(@ModelAttribute("quizPagePlayerAnswers") QuizPagePlayerAnswers quizPagePlayerAnswers) {
        LOGGER.info("{} - Getting {} answers", this.getClass().getSimpleName(), quizPagePlayerAnswers.getQuizPageAnswerModelList().size());

        quizPagePlayerAnswers.getQuizPageAnswerModelList().forEach(System.out::println);

        return "redirect:/";
    }

    public void calculateResults() {
        // the player selects an answer for each question
        // then presses the submit button

        // calculate the results
        quizService.calculateResults();

        // then show it to the player, on the same page (maybe)
    }
}

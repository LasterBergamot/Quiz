package com.quiz.controller.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.domain.trivia.Trivia;
import com.quiz.service.IQuizService;
import com.quiz.service.ITriviaService;

@Controller
public class QuizController {

    private static final String GET_MAPPING_QUIZ = "/quiz";

    private static final String VIEW_QUIZ = "quiz";

    private ITriviaService triviaService;
    private IQuizService quizService;

    @Autowired
    QuizController(ITriviaService triviaService, IQuizService quizService) {
        this.triviaService = triviaService;
        this.quizService = quizService;
    }

    @GetMapping(GET_MAPPING_QUIZ)
    public ModelAndView showQuizPage() {
        // get 10 quiz from the database - create new function to get just 10
        List<Trivia> trivia = triviaService.findAllTrivia();

        // then show it on the page

        return new ModelAndView(VIEW_QUIZ);
    }

    public void calculateResults() {
        // the user selects an answer for each question
        // then presses the submit button

        // calculate the results
        quizService.calculateResults();

        // then show it to the user, on the same page (maybe)
    }
}

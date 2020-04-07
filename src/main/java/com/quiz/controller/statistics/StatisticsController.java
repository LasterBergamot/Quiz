package com.quiz.controller.statistics;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.statistics.model.StatisticsModel;
import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.player.Player;
import com.quiz.domain.statistics.QuestionPointAnsweredOrNot;
import com.quiz.domain.statistics.QuestionWithGoodBadAnswers;
import com.quiz.service.IStatisticsService;
import com.quiz.service.ITriviaService;

@Controller
public class StatisticsController {

    private static final String GET_MAPPING_STATISTICS = "/statistics";

    private static final String VIEW_STATISTICS = "statistics";

    private IStatisticsService statisticsService;

    @Autowired
    StatisticsController(IStatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping(GET_MAPPING_STATISTICS)
    public ModelAndView showStatisticsPage() {
        ModelAndView modelAndView = new ModelAndView(VIEW_STATISTICS);
        Double averageOfPoints = statisticsService.calculateTheAverageOfPoints();
        Map<Category, Integer> numberOfQuestionAnsweredByCategory = statisticsService.getNumberOfQuestionsAnsweredByCategory();
        List<Player> leaderBoard = statisticsService.createLeaderBoard();
        List<String> questionsByEasyDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.EASY);
        List<String> questionsByMediumDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.MEDIUM);
        List<String> questionsByHardDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.HARD);
        Map<Category, List<QuestionPointAnsweredOrNot>> allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot =
                statisticsService.getAllOfTheQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot();

//        Map<Difficulty, Integer> numberOfQuestionAnsweredByDifficulty = statisticsService.getNumberOfQuestionsAnsweredByDifficulty();
//        System.out.println("Number of questions answered by difficulty:");
//        numberOfQuestionAnsweredByDifficulty.forEach((difficulty, numberOfQuestionsAnswered) -> {
//            System.out.println("Difficulty: " + difficulty + ", questions answered: " + numberOfQuestionsAnswered);
//        });
//        System.out.println();

//        List<QuestionWithGoodBadAnswers> allAnsweredQuestionsWithGoodAndBadAnswers = statisticsService.getAllOfTheAnsweredQuestionsWithGoodAndBadAnswers();
//        System.out.println("All answered questions with good and bad answers:");
//        allAnsweredQuestionsWithGoodAndBadAnswers.forEach(questionWithGoodBadAnswers -> {
//            System.out.println("Question: " + questionWithGoodBadAnswers.getQuestion() + ", number of good answers: " + questionWithGoodBadAnswers.getNumberOfGoodAnswers()
//                    + ", number of bad answers" + questionWithGoodBadAnswers.getNumberOfBadAnswers());
//        });
//        System.out.println();

        StatisticsModel statisticsModel = new StatisticsModel(averageOfPoints, numberOfQuestionAnsweredByCategory, leaderBoard, questionsByEasyDifficulty,
                questionsByMediumDifficulty, questionsByHardDifficulty, allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot);
        modelAndView.addObject("statisticsModel", statisticsModel);
        return modelAndView;
    }
}

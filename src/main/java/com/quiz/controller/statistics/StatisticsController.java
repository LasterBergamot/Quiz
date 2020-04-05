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
        // get the number of questions in the database
            // find all trivia

        // get every answered question for each player (dropdown list)
            // get all answer object for each player

        // get every point from each player
            // calculate depending on the answers OR create a Statistics table to keep track of everything (update after each game)

        // get the number of every correctly and wrongly answered question
        // get average of:
            // answered questions + correctly and wrongly answered ones
            // points

        // put them into one model

        Double averageOfPoints = statisticsService.calculateTheAverageOfPoints();
        System.out.println("The average of points: " + averageOfPoints);
        System.out.println();

//        Map<Difficulty, Integer> numberOfQuestionAnsweredByDifficulty = statisticsService.getNumberOfQuestionsAnsweredByDifficulty();
//        System.out.println("Number of questions answered by difficulty:");
//        numberOfQuestionAnsweredByDifficulty.forEach((difficulty, numberOfQuestionsAnswered) -> {
//            System.out.println("Difficulty: " + difficulty + ", questions answered: " + numberOfQuestionsAnswered);
//        });
//        System.out.println();

        Map<Category, Integer> numberOfQuestionAnsweredByCategory = statisticsService.getNumberOfQuestionsAnsweredByCategory();
        System.out.println("Number of questions answered by category:");
        numberOfQuestionAnsweredByCategory.forEach((category, numberOfQuestionsAnswered) -> {
            System.out.println("Category: " + category + ", questions answered: " + numberOfQuestionsAnswered);
        });
        System.out.println();

        List<Player> leaderBoard = statisticsService.createLeaderBoard();
        System.out.println("Leaderboard:");
        leaderBoard.forEach(player -> System.out.println("Name: " + player.getName() + ", age: " + player.getAge() + ", points: " + player.getGainedPoints()));
        System.out.println();

//        List<QuestionWithGoodBadAnswers> allAnsweredQuestionsWithGoodAndBadAnswers = statisticsService.getAllOfTheAnsweredQuestionsWithGoodAndBadAnswers();
//        System.out.println("All answered questions with good and bad answers:");
//        allAnsweredQuestionsWithGoodAndBadAnswers.forEach(questionWithGoodBadAnswers -> {
//            System.out.println("Question: " + questionWithGoodBadAnswers.getQuestion() + ", number of good answers: " + questionWithGoodBadAnswers.getNumberOfGoodAnswers()
//                    + ", number of bad answers" + questionWithGoodBadAnswers.getNumberOfBadAnswers());
//        });
//        System.out.println();

        System.out.println("Questions by each difficulty:");
        for (Difficulty difficulty : Difficulty.values()) {
            System.out.println("Questions by " + difficulty.getDifficulty() + " difficulty:");
            List<String> questionsByDifficulty = statisticsService.getQuestionsByDifficulty(difficulty);
            questionsByDifficulty.forEach(System.out::println);
        }
        System.out.println();

        List<String> questionsByEasyDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.EASY);
        List<String> questionsByMediumDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.MEDIUM);
        List<String> questionsByHardDifficulty = statisticsService.getQuestionsByDifficulty(Difficulty.HARD);

        System.out.println("All questions for each category with points and if they are answered or not:");
        Map<Category, List<QuestionPointAnsweredOrNot>> allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot = statisticsService.getAllOfTheQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot();
        allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot.forEach((category, questionPointAnsweredOrNots) -> {
            System.out.println("Questions for category: " + category);
            questionPointAnsweredOrNots.forEach(questionPointAnsweredOrNot -> {
                System.out.println("Question: " + questionPointAnsweredOrNot.getQuestion() + ", point: " + questionPointAnsweredOrNot.getPoint()
                        + ", answered: " + questionPointAnsweredOrNot.isAnswered());
            });
        });

        StatisticsModel statisticsModel = new StatisticsModel(averageOfPoints, numberOfQuestionAnsweredByCategory, leaderBoard, questionsByEasyDifficulty,
                questionsByMediumDifficulty, questionsByHardDifficulty, allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot);
        modelAndView.addObject("statisticsModel", statisticsModel);
        return modelAndView;
    }
}

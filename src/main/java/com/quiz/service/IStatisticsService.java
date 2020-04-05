package com.quiz.service;

import java.util.List;
import java.util.Map;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.player.Player;
import com.quiz.domain.statistics.QuestionPointAnsweredOrNot;
import com.quiz.domain.statistics.QuestionWithGoodBadAnswers;

public interface IStatisticsService {

    Integer calculateTheAverageOfPoints();
    Map<Difficulty, Integer> getNumberOfQuestionsAnsweredByDifficulty();
    Map<Category, Integer> getNumberOfQuestionsAnsweredByCategory();
    List<Player> createLeaderBoard();
    List<QuestionWithGoodBadAnswers> getAllOfTheAnsweredQuestionsWithGoodAndBadAnswers();
    List<String> getQuestionsByDifficulty(Difficulty difficulty);
    Map<Category, List<QuestionPointAnsweredOrNot>> getAllOfTheQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot();
}

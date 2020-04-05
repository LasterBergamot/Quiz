package com.quiz.controller.statistics.model;

import java.util.List;
import java.util.Map;

import com.quiz.domain.category.Category;
import com.quiz.domain.player.Player;
import com.quiz.domain.statistics.QuestionPointAnsweredOrNot;

public class StatisticsModel {

    private Double averageOfPoints;
    Map<Category, Integer> numberOfQuestionAnsweredByCategory;
    List<Player> leaderBoard;
    List<String> questionsByEasyDifficulty;
    List<String> questionsByMediumDifficulty;
    List<String> questionsByHardDifficulty;
    Map<Category, List<QuestionPointAnsweredOrNot>> allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot;

    public StatisticsModel() {}

    public StatisticsModel(Double averageOfPoints, Map<Category, Integer> numberOfQuestionAnsweredByCategory, List<Player> leaderBoard,
            List<String> questionsByEasyDifficulty, List<String> questionsByMediumDifficulty, List<String> questionsByHardDifficulty,
            Map<Category, List<QuestionPointAnsweredOrNot>> allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot) {
        this.averageOfPoints = averageOfPoints;
        this.numberOfQuestionAnsweredByCategory = numberOfQuestionAnsweredByCategory;
        this.leaderBoard = leaderBoard;
        this.questionsByEasyDifficulty = questionsByEasyDifficulty;
        this.questionsByMediumDifficulty = questionsByMediumDifficulty;
        this.questionsByHardDifficulty = questionsByHardDifficulty;
        this.allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot = allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot;
    }

    public Double getAverageOfPoints() {
        return averageOfPoints;
    }

    public void setAverageOfPoints(Double averageOfPoints) {
        this.averageOfPoints = averageOfPoints;
    }

    public Map<Category, Integer> getNumberOfQuestionAnsweredByCategory() {
        return numberOfQuestionAnsweredByCategory;
    }

    public void setNumberOfQuestionAnsweredByCategory(Map<Category, Integer> numberOfQuestionAnsweredByCategory) {
        this.numberOfQuestionAnsweredByCategory = numberOfQuestionAnsweredByCategory;
    }

    public List<Player> getLeaderBoard() {
        return leaderBoard;
    }

    public void setLeaderBoard(List<Player> leaderBoard) {
        this.leaderBoard = leaderBoard;
    }

    public List<String> getQuestionsByEasyDifficulty() {
        return questionsByEasyDifficulty;
    }

    public void setQuestionsByEasyDifficulty(List<String> questionsByEasyDifficulty) {
        this.questionsByEasyDifficulty = questionsByEasyDifficulty;
    }

    public List<String> getQuestionsByMediumDifficulty() {
        return questionsByMediumDifficulty;
    }

    public void setQuestionsByMediumDifficulty(List<String> questionsByMediumDifficulty) {
        this.questionsByMediumDifficulty = questionsByMediumDifficulty;
    }

    public List<String> getQuestionsByHardDifficulty() {
        return questionsByHardDifficulty;
    }

    public void setQuestionsByHardDifficulty(List<String> questionsByHardDifficulty) {
        this.questionsByHardDifficulty = questionsByHardDifficulty;
    }

    public Map<Category, List<QuestionPointAnsweredOrNot>> getAllQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot() {
        return allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot;
    }

    public void setAllQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot(
            Map<Category, List<QuestionPointAnsweredOrNot>> allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot) {
        this.allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot = allQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot;
    }
}

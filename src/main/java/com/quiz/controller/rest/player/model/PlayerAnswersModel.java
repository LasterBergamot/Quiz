package com.quiz.controller.rest.player.model;

import java.util.List;

import com.quiz.controller.quiz.model.AnswerResultModel;

public class PlayerAnswersModel {

    private String playerName;
    private String playerAge;
    private List<AnswerResultModel> answerResultModelList;
    private String gainedPoints;

    public PlayerAnswersModel() {}

    public PlayerAnswersModel(String playerName, String playerAge, List<AnswerResultModel> answerResultModelList, String gainedPoints) {
        this.playerName = playerName;
        this.playerAge = playerAge;
        this.answerResultModelList = answerResultModelList;
        this.gainedPoints = gainedPoints;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerAge() {
        return playerAge;
    }

    public void setPlayerAge(String playerAge) {
        this.playerAge = playerAge;
    }

    public List<AnswerResultModel> getAnswerResultModelList() {
        return answerResultModelList;
    }

    public void setAnswerResultModelList(List<AnswerResultModel> answerResultModelList) {
        this.answerResultModelList = answerResultModelList;
    }

    public String getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(String gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    @Override
    public String toString() {
        return "PlayerAnswersModel{" + "playerName='" + playerName + '\'' + ", playerAge='" + playerAge + '\'' + ", answerResultModelList="
                + answerResultModelList + ", gainedPoints='" + gainedPoints + '\'' + '}';
    }
}

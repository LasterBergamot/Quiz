package com.quiz.controller.quiz.model;

import java.util.List;

public class ResultModel {

    private List<AnswerResultModel> answerResultModelList;
    private String gainedPoints;

    public ResultModel() {}

    public ResultModel(List<AnswerResultModel> answerResultModelList, String gainedPoints) {
        this.answerResultModelList = answerResultModelList;
        this.gainedPoints = gainedPoints;
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
        return "ResultModel{" + "answerResultModelList=" + answerResultModelList + ", gainedPoints='" + gainedPoints + '\'' + '}';
    }
}

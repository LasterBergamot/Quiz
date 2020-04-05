package com.quiz.controller.quiz.model;

import java.util.List;
import java.util.UUID;

public class QuizPagePlayerModel {

    private UUID uuid;
    private String name;
    private List<QuizPageTriviaModel> quizPageTriviaModelList;
    private ResultModel resultModel;

    public QuizPagePlayerModel() {}

    public QuizPagePlayerModel(String name) {
        this.name = name;
    }

    public QuizPagePlayerModel(String name, ResultModel resultModel) {
        this.name = name;
        this.resultModel = resultModel;
    }

    public QuizPagePlayerModel(UUID uuid, String name, List<QuizPageTriviaModel> quizPageTriviaModelList) {
        this.uuid = uuid;
        this.name = name;
        this.quizPageTriviaModelList = quizPageTriviaModelList;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<QuizPageTriviaModel> getQuizPageTriviaModelList() {
        return quizPageTriviaModelList;
    }

    public void setQuizPageTriviaModelList(List<QuizPageTriviaModel> quizPageTriviaModelList) {
        this.quizPageTriviaModelList = quizPageTriviaModelList;
    }

    public ResultModel getResultModel() {
        return resultModel;
    }

    public void setResultModel(ResultModel resultModel) {
        this.resultModel = resultModel;
    }

    @Override
    public String toString() {
        return "QuizPagePlayerModel{" + "uuid=" + uuid + ", name='" + name + '\'' + ", quizPageTriviaModelList=" + quizPageTriviaModelList + ", resultModel="
                + resultModel + '}';
    }
}

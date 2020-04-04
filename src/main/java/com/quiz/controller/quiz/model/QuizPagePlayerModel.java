package com.quiz.controller.quiz.model;

import java.util.List;
import java.util.UUID;

public class QuizPagePlayerModel {

    private UUID uuid;
    private String name;
    private List<QuizPageTriviaModel> quizPageTriviaModelList;

    public QuizPagePlayerModel() {}

    public QuizPagePlayerModel(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
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

    @Override
    public String toString() {
        return "QuizPagePlayerModel{" + "uuid=" + uuid + ", name='" + name + '\'' + ", quizPageTriviaModelList=" + quizPageTriviaModelList + '}';
    }
}

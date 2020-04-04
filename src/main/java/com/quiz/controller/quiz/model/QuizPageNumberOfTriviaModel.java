package com.quiz.controller.quiz.model;

public class QuizPageNumberOfTriviaModel {

    private Integer numberOfTrivia;

    public QuizPageNumberOfTriviaModel() {}

    public QuizPageNumberOfTriviaModel(Integer numberOfTrivia) {
        this.numberOfTrivia = numberOfTrivia;
    }

    public Integer getNumberOfTrivia() {
        return numberOfTrivia;
    }

    public void setNumberOfTrivia(Integer numberOfTrivia) {
        this.numberOfTrivia = numberOfTrivia;
    }

    @Override
    public String toString() {
        return "QuizPageNumberOfTriviaModel{" + "numberOfTrivia=" + numberOfTrivia + '}';
    }
}

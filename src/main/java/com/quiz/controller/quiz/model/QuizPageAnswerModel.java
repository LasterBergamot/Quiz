package com.quiz.controller.quiz.model;

public class QuizPageAnswerModel {

    private String triviaUUID;
    private String selectedAnswer;

    public QuizPageAnswerModel() {}

    public QuizPageAnswerModel(String triviaUUID, String selectedAnswer) {
        this.triviaUUID = triviaUUID;
        this.selectedAnswer = selectedAnswer;
    }

    public String getTriviaUUID() {
        return triviaUUID;
    }

    public void setTriviaUUID(String triviaUUID) {
        this.triviaUUID = triviaUUID;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    @Override
    public String toString() {
        return "QuizPageAnswerModel{" + "triviaUUID='" + triviaUUID + '\'' + ", selectedAnswer='" + selectedAnswer + '\'' + '}';
    }
}

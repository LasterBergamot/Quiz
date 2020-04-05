package com.quiz.controller.quiz.model;

import java.util.List;

public class QuizPageTriviaModel {

    private String uuid;
    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correctAnswer;
    private List<String> allAnswers;

    public QuizPageTriviaModel() {}

    public QuizPageTriviaModel(String uuid, String category, String type, String difficulty, String question, String correctAnswer, List<String> allAnswers) {
        this.uuid = uuid;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allAnswers = allAnswers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getAllAnswers() {
        return allAnswers;
    }

    public void setAllAnswers(List<String> allAnswers) {
        this.allAnswers = allAnswers;
    }

    @Override
    public String toString() {
        return "QuizPageTriviaModel{" + "uuid='" + uuid + '\'' + ", category='" + category + '\'' + ", type='" + type + '\'' + ", difficulty='" + difficulty
                + '\'' + ", question='" + question + '\'' + ", correctAnswer='" + correctAnswer + '\'' + ", allAnswers=" + allAnswers + '}';
    }
}

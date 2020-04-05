package com.quiz.controller.quiz.model;

public class AnswerResultModel {

    private String categoryName;
    private String type;
    private String difficulty;
    private String question;
    private String correctAnswer;
    private String selectedAnswer;
    private String answeredCorrectly;
    private String point;

    public AnswerResultModel() {}

    public AnswerResultModel(String categoryName, String type, String difficulty, String question, String correctAnswer, String selectedAnswer, String answeredCorrectly,
            String point) {
        this.categoryName = categoryName;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.selectedAnswer = selectedAnswer;
        this.answeredCorrectly = answeredCorrectly;
        this.point = point;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public String getAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(String answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "AnswerResultModel{" + "categoryName='" + categoryName + '\'' + ", type='" + type + '\'' + ", difficulty='" + difficulty + '\'' + ", question='"
                + question + '\'' + ", correctAnswer='" + correctAnswer + '\'' + ", selectedAnswer='" + selectedAnswer + '\'' + ", answeredCorrectly='"
                + answeredCorrectly + '\'' + ", point='" + point + '\'' + '}';
    }
}

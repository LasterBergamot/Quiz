package com.quiz.domain.statistics;

public class QuestionWithGoodBadAnswers {

    private String question;
    private Integer numberOfGoodAnswers;
    private Integer numberOfBadAnswers;

    public QuestionWithGoodBadAnswers() {}

    public QuestionWithGoodBadAnswers(String question, Integer numberOfGoodAnswers, Integer numberOfBadAnswers) {
        this.question = question;
        this.numberOfGoodAnswers = numberOfGoodAnswers;
        this.numberOfBadAnswers = numberOfBadAnswers;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getNumberOfGoodAnswers() {
        return numberOfGoodAnswers;
    }

    public void setNumberOfGoodAnswers(Integer numberOfGoodAnswers) {
        this.numberOfGoodAnswers = numberOfGoodAnswers;
    }

    public Integer getNumberOfBadAnswers() {
        return numberOfBadAnswers;
    }

    public void setNumberOfBadAnswers(Integer numberOfBadAnswers) {
        this.numberOfBadAnswers = numberOfBadAnswers;
    }
}

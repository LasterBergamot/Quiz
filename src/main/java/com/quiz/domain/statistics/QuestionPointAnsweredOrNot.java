package com.quiz.domain.statistics;

public class QuestionPointAnsweredOrNot {

    private String question;
    private Integer point;
    private boolean answered;

    public QuestionPointAnsweredOrNot() {}

    public QuestionPointAnsweredOrNot(String question, Integer point, boolean answered) {
        this.question = question;
        this.point = point;
        this.answered = answered;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public boolean isAnswered() {
        return answered;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }


}

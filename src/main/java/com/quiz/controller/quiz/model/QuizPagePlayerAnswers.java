package com.quiz.controller.quiz.model;

import java.util.List;

public class QuizPagePlayerAnswers {

    private List<QuizPageAnswerModel> quizPageAnswerModelList;

    public QuizPagePlayerAnswers() {}

    public QuizPagePlayerAnswers(List<QuizPageAnswerModel> quizPageAnswerModelList) {
        this.quizPageAnswerModelList = quizPageAnswerModelList;
    }

    public List<QuizPageAnswerModel> getQuizPageAnswerModelList() {
        return quizPageAnswerModelList;
    }

    public void setQuizPageAnswerModelList(List<QuizPageAnswerModel> quizPageAnswerModelList) {
        this.quizPageAnswerModelList = quizPageAnswerModelList;
    }

    @Override
    public String toString() {
        return "QuizPagePlayerAnswers{" + "quizPageAnswerModelList=" + quizPageAnswerModelList + '}';
    }
}

package com.quiz.controller.quiz.model;

import java.util.List;
import java.util.UUID;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.type.Type;

public class QuizPageTriviaModel {

    private UUID uuid;
    private Category category;
    private Type type;
    private Difficulty difficulty;
    private String question;
    private String correctAnswer;
    private List<String> allAnswers;

    public QuizPageTriviaModel() {}

    public QuizPageTriviaModel(UUID uuid, Category category, Type type, Difficulty difficulty, String question, String correctAnswer, List<String> allAnswers) {
        this.uuid = uuid;
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.allAnswers = allAnswers;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
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
        return "QuizPageTriviaModel{" + "uuid=" + uuid + ", category=" + category + ", type=" + type + ", difficulty=" + difficulty + ", question='" + question
                + '\'' + ", correctAnswer='" + correctAnswer + '\'' + ", allAnswers=" + allAnswers + '}';
    }
}

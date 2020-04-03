package com.quiz.domain.answer;

import java.util.UUID;

import com.quiz.domain.trivia.Trivia;

public class Answer {

    private UUID uuid;
    private Trivia trivia;

    private String selectedAnswer;

    private boolean answeredCorrectly;

    public Answer() {}

    public Answer(UUID uuid, Trivia trivia, String selectedAnswer, boolean answeredCorrectly) {
        this.uuid = uuid;
        this.trivia = trivia;
        this.selectedAnswer = selectedAnswer;
        this.answeredCorrectly = answeredCorrectly;
    }

    public Trivia getTrivia() {
        return trivia;
    }

    public void setTrivia(Trivia trivia) {
        this.trivia = trivia;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }
}

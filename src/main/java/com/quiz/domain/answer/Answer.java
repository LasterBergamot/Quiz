package com.quiz.domain.answer;

import java.util.UUID;

import com.quiz.domain.trivia.Trivia;

public class Answer {

    private UUID uuid;
    private Trivia trivia;
    private boolean answeredCorrectly;

    public Answer() {}

    public Answer(UUID uuid, Trivia trivia, boolean answeredCorrectly) {
        this.uuid = uuid;
        this.trivia = trivia;
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
}

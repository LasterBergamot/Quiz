package com.quiz.repository.entity.answer;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.quiz.repository.entity.EntityWithUUID;
import com.quiz.repository.entity.trivia.TriviaEntity;

@Entity
public class AnswerEntity extends EntityWithUUID {

    @OneToOne(targetEntity = TriviaEntity.class)
    private TriviaEntity triviaEntity;

    private boolean answeredCorrectly;

    public AnswerEntity() {}

    public AnswerEntity(TriviaEntity triviaEntity, boolean answeredCorrectly) {
        this.triviaEntity = triviaEntity;
        this.answeredCorrectly = answeredCorrectly;
    }

    public TriviaEntity getTriviaEntity() {
        return triviaEntity;
    }

    public void setTriviaEntity(TriviaEntity triviaEntity) {
        this.triviaEntity = triviaEntity;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
}

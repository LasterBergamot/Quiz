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

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
}

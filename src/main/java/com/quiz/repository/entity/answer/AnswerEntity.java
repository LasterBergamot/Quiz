package com.quiz.repository.entity.answer;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.quiz.repository.entity.EntityWithUUID;
import com.quiz.repository.entity.player.PlayerEntity;
import com.quiz.repository.entity.trivia.TriviaEntity;

@Entity
@Table(name = "answers")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AnswerEntity extends EntityWithUUID implements Serializable {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trivia_uuid")
    @JsonIgnore
    private TriviaEntity triviaEntity;

    @Column(name = "selected_answer")
    private String selectedAnswer;

    @Column(name = "answered_correctly")
    private boolean answeredCorrectly;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "player_uuid")
    @JsonIgnore
    private PlayerEntity playerEntity;

    public AnswerEntity() {}

    public AnswerEntity(String selectedAnswer, boolean answeredCorrectly) {
        this.selectedAnswer = selectedAnswer;
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

    public String getSelectedAnswer() {
        return selectedAnswer;
    }

    public void setSelectedAnswer(String selectedAnswer) {
        this.selectedAnswer = selectedAnswer;
    }

    public PlayerEntity getPlayerEntity() {
        return playerEntity;
    }

    public void setPlayerEntity(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }
}

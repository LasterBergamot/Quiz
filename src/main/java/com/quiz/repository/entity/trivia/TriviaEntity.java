package com.quiz.repository.entity.trivia;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.repository.entity.EntityWithUUID;
import com.quiz.repository.entity.answer.AnswerEntity;

@Entity
@Table(name = "trivia")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TriviaEntity extends EntityWithUUID implements Serializable {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private TriviaDTO triviaDTO;

    @OneToOne(mappedBy = "triviaEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private AnswerEntity answerEntity;

    public TriviaEntity() {}

    public TriviaEntity(TriviaDTO triviaDTO) {
        this.triviaDTO = triviaDTO;
    }

    public TriviaDTO getTriviaDTO() {
        return triviaDTO;
    }

    public void setTriviaDTO(TriviaDTO triviaDTO) {
        this.triviaDTO = triviaDTO;
    }

    public AnswerEntity getAnswerEntity() {
        return answerEntity;
    }

    public void setAnswerEntity(AnswerEntity answerEntity) {
        this.answerEntity = answerEntity;
    }
}

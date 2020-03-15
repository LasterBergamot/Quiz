package com.quiz.repository.entity.trivia;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import org.hibernate.annotations.Type;

import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.repository.entity.EntityWithUUID;

@Entity
public class TriviaEntity extends EntityWithUUID {

    @Type(type = "jsonb")
    @Column(columnDefinition = "jsonb")
    @Basic(fetch = FetchType.LAZY)
    private TriviaDTO triviaDTO;

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
}

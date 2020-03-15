package com.quiz.repository.entity.user;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.quiz.repository.entity.EntityWithUUID;
import com.quiz.repository.entity.answer.AnswerEntity;

@Entity
public class UserEntity extends EntityWithUUID {

    private String name;
    private Integer age;

    @OneToMany(targetEntity = AnswerEntity.class)
    private List<AnswerEntity> answerEntities;

}

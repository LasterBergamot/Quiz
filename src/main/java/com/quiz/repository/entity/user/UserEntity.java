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

    public UserEntity() {}

    public UserEntity(String name, Integer age, List<AnswerEntity> answerEntities) {
        this.name = name;
        this.age = age;
        this.answerEntities = answerEntities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<AnswerEntity> getAnswerEntities() {
        return answerEntities;
    }

    public void setAnswerEntities(List<AnswerEntity> answerEntities) {
        this.answerEntities = answerEntities;
    }
}

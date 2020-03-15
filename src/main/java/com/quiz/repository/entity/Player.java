package com.quiz.repository.entity;

import java.util.List;
import javax.persistence.Entity;

@Entity
public class Player extends EntityWithUUID {

    private String name;
    private Integer age;


}

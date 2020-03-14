package com.quiz.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quiz.domain.trivia.Trivia;

@Component
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private List<Trivia> triviaList;

    public User() {}

    public User(String name, Integer age) {
        triviaList = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public List<Trivia> getTriviaList() {
        return triviaList;
    }

    public void setTriviaList(List<Trivia> triviaList) {
        this.triviaList = triviaList;
    }
}

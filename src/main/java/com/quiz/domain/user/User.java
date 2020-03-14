package com.quiz.domain.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quiz.domain.trivia.Trivia;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Component
public class User {

    private Integer id;
    private String name;
    private Integer age;
    private List<Trivia> triviaList;

    public User(String name, Integer age) {
        triviaList = new ArrayList<>();
    }

    public void setTriviaList(List<Trivia> triviaList) {
        this.triviaList = triviaList;
    }
}

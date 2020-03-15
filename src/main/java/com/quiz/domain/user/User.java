package com.quiz.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.quiz.domain.trivia.Trivia;

@Component
public class User {

    private UUID uuid;
    private String name;
    private Integer age;
    private List<Trivia> triviaList;

    public User() {}

    public User(String name, Integer age) {
        triviaList = new ArrayList<>();
    }

    public UUID getUuid() {
        return uuid;
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

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid) && Objects.equals(name, user.name) && Objects.equals(age, user.age) && Objects
                .equals(triviaList, user.triviaList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, age, triviaList);
    }

    @Override
    public String toString() {
        return "User{" + "uuid=" + uuid + ", name='" + name + '\'' + ", age=" + age + ", triviaList=" + triviaList + '}';
    }
}

package com.quiz.domain.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.quiz.domain.answer.Answer;
import com.quiz.domain.trivia.Trivia;

@Component
public class User {

    private UUID uuid;
    private String name;
    private Integer age;
    private List<Answer> answers;

    public User() {}

    public User(UUID uuid, String name, Integer age, List<Answer> answers) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.answers = answers;
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

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        User user = (User) o;
        return Objects.equals(uuid, user.uuid) && Objects.equals(name, user.name) && Objects.equals(age, user.age) && Objects.equals(answers, user.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, age, answers);
    }

    @Override public String toString() {
        return "User{" + "uuid=" + uuid + ", name='" + name + '\'' + ", age=" + age + ", answers=" + answers + '}';
    }
}

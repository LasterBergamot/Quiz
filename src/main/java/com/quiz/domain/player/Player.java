package com.quiz.domain.player;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.stereotype.Component;

import com.quiz.domain.answer.Answer;

@Component
public class Player {

    private UUID uuid;
    private String name;
    private Integer age;
    private List<Answer> answers;
    private Integer gainedPoints = 0;

    public Player() {}

    public Player(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Player(String name, Integer age, List<Answer> answers) {
        this.name = name;
        this.age = age;
        this.answers = answers;
    }

    public Player(UUID uuid, String name, Integer age, List<Answer> answers) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.answers = answers;
    }

    public Player(UUID uuid, String name, Integer age, List<Answer> answers, Integer gainedPoints) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
        this.answers = answers;
        this.gainedPoints = gainedPoints;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGainedPoints() {
        return gainedPoints;
    }

    public void setGainedPoints(Integer gainedPoints) {
        this.gainedPoints = gainedPoints;
    }

    @Override
    public String toString() {
        return "Player{" + "uuid=" + uuid + ", name='" + name + '\'' + ", age=" + age + ", answers=" + answers + ", gainedPoints=" + gainedPoints + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return Objects.equals(uuid, player.uuid) && Objects.equals(name, player.name) && Objects.equals(age, player.age) && Objects
                .equals(answers, player.answers) && Objects.equals(gainedPoints, player.gainedPoints);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, name, age, answers, gainedPoints);
    }
}

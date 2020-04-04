package com.quiz.controller.rest.player.model;

import java.util.UUID;

public class PlayerModifyModel {

    private UUID uuid;
    private String name;
    private Integer age;

    public PlayerModifyModel() {}

    public PlayerModifyModel(UUID uuid, String name, Integer age) {
        this.uuid = uuid;
        this.name = name;
        this.age = age;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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

    @Override public String toString() {
        return "PlayerModifyModel{" + "uuid=" + uuid + ", name='" + name + '\'' + ", age=" + age + '}';
    }
}

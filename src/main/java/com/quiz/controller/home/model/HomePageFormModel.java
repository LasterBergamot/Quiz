package com.quiz.controller.home.model;

public class HomePageFormModel {

    private String playerUuid;

    public HomePageFormModel() {}

    public HomePageFormModel(String playerUuid) {
        this.playerUuid = playerUuid;
    }

    public String getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(String playerUuid) {
        this.playerUuid = playerUuid;
    }
}

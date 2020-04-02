package com.quiz.controller.home.model;

import java.util.UUID;

public class HomePageFormModel {

    private UUID playerUuid;

    public HomePageFormModel() {}

    public HomePageFormModel(UUID playerUuid) {
        this.playerUuid = playerUuid;
    }

    public UUID getPlayerUuid() {
        return playerUuid;
    }

    public void setPlayerUuid(UUID playerUuid) {
        this.playerUuid = playerUuid;
    }
}

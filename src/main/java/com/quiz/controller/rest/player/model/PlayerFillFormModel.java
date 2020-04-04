package com.quiz.controller.rest.player.model;

import java.util.UUID;

public class PlayerFillFormModel {

    private UUID playerUUID;

    public PlayerFillFormModel() {}

    public PlayerFillFormModel(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    @Override public String toString() {
        return "PlayerFillFormModel{" + "playerUUID=" + playerUUID + '}';
    }
}

package com.quiz.controller.rest.player.model;

import java.util.UUID;

public class PlayerRestModel {

    private UUID playerUUID;

    public PlayerRestModel() {}

    public PlayerRestModel(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public void setPlayerUUID(UUID playerUUID) {
        this.playerUUID = playerUUID;
    }

    @Override public String toString() {
        return "PlayerRestModel{" + "playerUUID=" + playerUUID + '}';
    }
}

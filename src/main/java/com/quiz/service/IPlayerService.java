package com.quiz.service;

import java.util.List;
import java.util.UUID;

import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.domain.player.Player;

public interface IPlayerService {

    Player savePlayer(Player player);
    Player modifyPlayer(PlayerModifyModel playerModifyModel);
    void deletePlayerByUuid(UUID uuid);
    Player findPlayerByUuid(UUID uuid);
    List<Player> findAllPlayers();
}

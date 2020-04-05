package com.quiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.domain.player.Player;
import com.quiz.repository.entity.player.PlayerEntity;

public interface IPlayerService {

    Player savePlayer(Player player);
    Player modifyPlayer(PlayerModifyModel playerModifyModel);
    void deletePlayerByUuid(UUID uuid);
    Player findPlayerEntityByUuid(UUID uuid);
    Optional<PlayerEntity> findPlayerEntityByUuid(String uuid);
    List<Player> findAllPlayers();
}

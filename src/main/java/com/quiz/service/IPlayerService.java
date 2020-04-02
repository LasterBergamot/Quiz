package com.quiz.service;

import java.util.List;
import java.util.UUID;

import com.quiz.domain.player.Player;

public interface IPlayerService {

    void savePlayer(Player player);
    void deletePlayerByUuid(UUID uuid);
    Player findPlayerByUuid(UUID uuid);
    List<Player> findAllPlayers();
}

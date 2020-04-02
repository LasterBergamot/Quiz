package com.quiz.service;

import java.util.List;

import com.quiz.domain.player.Player;

public interface IHomeService {

//    void populateDatabase();

    List<Player> findAllPlayers();
}

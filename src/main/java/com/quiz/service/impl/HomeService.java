package com.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.domain.player.Player;
import com.quiz.service.IHomeService;
import com.quiz.service.ITriviaService;
import com.quiz.service.IPlayerService;

@Service
public class HomeService implements IHomeService {

    private static final String OPEN_TRIVIA_DB_API_URL = "https://opentdb.com/api.php?amount=10";

    private ITriviaService triviaService;
    private IPlayerService playerService;
    private RestTemplate restTemplate;

    @Autowired HomeService(ITriviaService triviaService, IPlayerService playerService, RestTemplate restTemplate) {
        this.triviaService = triviaService;
        this.playerService = playerService;
        this.restTemplate = restTemplate;
    }

    @Override
    public void populateDatabase() {
        OpenTriviaDatabaseResponse openTriviaDatabaseResponse = restTemplate.getForObject(OPEN_TRIVIA_DB_API_URL, OpenTriviaDatabaseResponse.class);

        if (openTriviaDatabaseResponse != null) {
            triviaService.saveAllTrivia(openTriviaDatabaseResponse.getResults());
            System.out.println();
            triviaService.findAllTrivia().forEach(System.out::println);
        }
    }

    @Override
    public List<Player> findAllPlayers() {
        return playerService.findAllPlayers();
    }
}

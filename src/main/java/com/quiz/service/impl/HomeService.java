package com.quiz.service.impl;

import java.util.List;
import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.domain.player.Player;
import com.quiz.service.IHomeService;
import com.quiz.service.IPlayerService;
import com.quiz.service.ITriviaService;

@Service
public class HomeService implements IHomeService {

    private static final String OPEN_TRIVIA_DB_API_URL = "https://opentdb.com/api.php?amount=%s";

    private final static Logger LOGGER = LoggerFactory.getLogger(IHomeService.class);

    private ITriviaService triviaService;
    private IPlayerService playerService;
    private RestTemplate restTemplate;

    @Autowired HomeService(ITriviaService triviaService, IPlayerService playerService, RestTemplate restTemplate) {
        this.triviaService = triviaService;
        this.playerService = playerService;
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void populateDatabase() {
        int amount = 10;
        OpenTriviaDatabaseResponse openTriviaDatabaseResponse = restTemplate.getForObject(String.format(OPEN_TRIVIA_DB_API_URL, amount), OpenTriviaDatabaseResponse.class);

        if (openTriviaDatabaseResponse != null) {
            LOGGER.info("{} - Populating database with {} trivia", this.getClass().getSimpleName(), amount);

            triviaService.saveAllTrivia(openTriviaDatabaseResponse.getResults());
        }
    }

    @Override
    public List<Player> findAllPlayers() {
        LOGGER.info("{} - Finding all Players", this.getClass().getSimpleName());
        return playerService.findAllPlayers();
    }
}

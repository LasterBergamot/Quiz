package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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

    private final static Logger LOGGER = LoggerFactory.getLogger(IHomeService.class);

    private static final String OPEN_TRIVIA_DB_API_URL = "https://opentdb.com/api.php?amount=%s";

    private static final int NUMBER_OF_ITERATIONS = 4;
    private static final int RANDOM_MIN_VALUE = 40;
    private static final int RANDOM_MAX_VALUE = 50;

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
        List<OpenTriviaDatabaseResponse> openTriviaDatabaseResponses = new ArrayList<>();
        Random random = new Random();
        int totalAmount = 0;

        for (int currentIteration = 1; currentIteration <= NUMBER_OF_ITERATIONS; currentIteration++) {
            int amount = random.nextInt(RANDOM_MAX_VALUE - RANDOM_MIN_VALUE) + RANDOM_MIN_VALUE;
            totalAmount += amount;
            openTriviaDatabaseResponses.add(restTemplate.getForObject(String.format(OPEN_TRIVIA_DB_API_URL, amount), OpenTriviaDatabaseResponse.class));
        }

        if (!openTriviaDatabaseResponses.isEmpty()) {
            LOGGER.info("{} - Populating database with {} trivia", this.getClass().getSimpleName(), totalAmount);

            triviaService.saveAllTrivia(openTriviaDatabaseResponses);
        }
    }

    @Override
    public List<Player> findAllPlayers() {
        LOGGER.info("{} - Finding all Players", this.getClass().getSimpleName());
        return playerService.findAllPlayers();
    }
}

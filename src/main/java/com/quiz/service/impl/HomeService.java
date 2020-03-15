package com.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.domain.user.User;
import com.quiz.service.IHomeService;
import com.quiz.service.ITriviaService;
import com.quiz.service.IUserService;

@Service
public class HomeService implements IHomeService {

    private static final String OPEN_TRIVIA_DB_API_URL = "https://opentdb.com/api.php?amount=10";

    private ITriviaService triviaService;
    private IUserService userService;
    private RestTemplate restTemplate;

    @Autowired HomeService(ITriviaService triviaService, IUserService userService, RestTemplate restTemplate) {
        this.triviaService = triviaService;
        this.userService = userService;
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
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }
}

package com.quiz.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.domain.trivia.TriviaDTO;
import com.quiz.service.IQuizService;

@RestController
public class RestQuizController {

    private final String POST_MAPPING_REST_GET_TRIVIA = "/rest/trivia";

    private IQuizService quizService;

    @Autowired
    RestQuizController(IQuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping(POST_MAPPING_REST_GET_TRIVIA)
    void getTriviaFromAPI(@RequestBody TriviaDTO triviaDTO) {

    }
}

package com.quiz.controller.rest.trivia;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.domain.trivia.Trivia;
import com.quiz.service.ITriviaService;

@RestController
public class TriviaRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(TriviaRestController.class);

    private ITriviaService triviaService;

    @Autowired
    public TriviaRestController(ITriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @GetMapping("/rest/getAllTrivia")
    public List<Trivia> getAllTrivia() {
        return triviaService.findAllTrivia();
    }
}

package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.service.IQuizService;

@Controller
public class QuizController {

    private final String GET_MAPPING_HOME = "/";

    private final String VIEW_HOME = "home";

    private IQuizService quizService;
    private RestTemplate restTemplate;

    @Autowired
    QuizController(IQuizService quizService, RestTemplate restTemplate) {
        this.quizService = quizService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(GET_MAPPING_HOME)
    public ModelAndView showHomePage() {
       OpenTriviaDatabaseResponse openTriviaDatabaseResponse = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", OpenTriviaDatabaseResponse.class);

       if (openTriviaDatabaseResponse != null) {
           quizService.printAllTrivia(openTriviaDatabaseResponse.getResults());
           quizService.saveAllTrivia(openTriviaDatabaseResponse.getResults());
           System.out.println();
           quizService.findAllTrivia();
       }

       return new ModelAndView(VIEW_HOME);
    }
}

package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.domain.trivia.TriviaDTOList;
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
       TriviaDTOList triviaDTOList = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", TriviaDTOList.class);
       quizService.printAllTrivia(triviaDTOList.getTriviaDTOList());

       return new ModelAndView(VIEW_HOME);
    }
}

package com.quiz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.quiz.domain.trivia.TriviaDTOList;
import com.quiz.service.IQuizService;

@Controller
public class QuizController {

    private final String HOME = "/";

    private IQuizService quizService;
    private RestTemplate restTemplate;

    @Autowired
    QuizController(IQuizService quizService, RestTemplate restTemplate) {
        this.quizService = quizService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(HOME)
    public void printTrivia() {
       TriviaDTOList triviaDTOList = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", TriviaDTOList.class);
       quizService.printAllTrivia(triviaDTOList.getTriviaDTOList());

//        ResponseEntity<TriviaDTO[]> responseEntity = restTemplate.getForEntity("https://opentdb.com/api.php?amount=10", TriviaDTO[].class);
//        System.out.println(Arrays.toString(responseEntity.getBody()));
    }
}

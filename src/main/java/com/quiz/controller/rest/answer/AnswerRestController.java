package com.quiz.controller.rest.answer;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.domain.answer.Answer;
import com.quiz.service.IAnswerService;

@RestController
public class AnswerRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(AnswerRestController.class);

    private IAnswerService answerService;

    @Autowired
    public AnswerRestController(IAnswerService answerService) {
        this.answerService = answerService;
    }

    @GetMapping("/rest/getAllAnswers")
    public List<Answer> getAllAnswers() {
        return answerService.findAllAnswers();
    }
}

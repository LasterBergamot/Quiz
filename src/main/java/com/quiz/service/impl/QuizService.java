package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.trivia.Trivia;
import com.quiz.service.IQuizService;
import com.quiz.service.ITriviaService;

@Service
public class QuizService implements IQuizService {

    private ITriviaService triviaService;

    @Autowired
    QuizService(ITriviaService triviaService) {
        this.triviaService = triviaService;
    }

    @Override
    public List<Trivia> findANumberOfTrivia(int numberOfTrivia) {
        List<Trivia> allTrivia = new ArrayList<>(new HashSet<>(triviaService.findAllTrivia()));
        Collections.shuffle(allTrivia);

        return null;
    }

    @Override
    public void calculateResults() {
        // get a List of Answers
        // return with a model with the Answers and the points with them
    }
}

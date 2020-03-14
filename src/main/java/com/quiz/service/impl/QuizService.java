package com.quiz.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.TriviaDTO;
import com.quiz.domain.trivia.TriviaDTOTransformer;
import com.quiz.service.IQuizService;

@Service
public class QuizService implements IQuizService {

    private TriviaDTOTransformer triviaDTOTransformer;

    @Autowired
    QuizService(TriviaDTOTransformer triviaDTOTransformer) {
        this.triviaDTOTransformer = triviaDTOTransformer;
    }

    @Override
    public void printAllTrivia(List<TriviaDTO> triviaDTOList) {
        triviaDTOTransformer.transformTriviaDTOListToTriviaList(triviaDTOList).forEach(System.out::println);
    }
}

package com.quiz.service;

import java.util.List;

import com.quiz.domain.trivia.Trivia;

public interface IQuizService {

    List<Trivia> findANumberOfTrivia(int numberOfTrivia);
    void calculateResults();
}

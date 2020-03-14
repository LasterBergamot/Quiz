package com.quiz.service;

import java.util.List;

import com.quiz.domain.trivia.TriviaDTO;

public interface IQuizService {

    void printAllTrivia(List<TriviaDTO> triviaDTO);
}

package com.quiz.service;

import java.util.List;

import com.quiz.domain.trivia.dto.TriviaDTO;

public interface ITriviaService {

    void saveTrivia(TriviaDTO triviaDTO);

    void saveAllTrivia(List<TriviaDTO> triviaDTOs);

    void printAllTrivia(List<TriviaDTO> triviaDTOs);
}

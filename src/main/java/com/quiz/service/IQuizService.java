package com.quiz.service;

import java.util.List;
import java.util.UUID;

import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.dto.TriviaDTO;

public interface IQuizService {

    void saveTrivia(TriviaDTO triviaDTO);

    void saveAllTrivia(List<TriviaDTO> triviaDTOs);

    void printAllTrivia(List<TriviaDTO> triviaDTOs);

    Trivia findTriviaById(UUID uuid);

    List<Trivia> findAllTrivia();
}

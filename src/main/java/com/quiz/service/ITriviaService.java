package com.quiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.repository.entity.TriviaEntity;

public interface ITriviaService {

    void saveTrivia(TriviaDTO triviaDTO);

    void saveAllTrivia(List<TriviaDTO> triviaDTOs);

    void printAllTrivia(List<TriviaDTO> triviaDTOs);

    Optional<TriviaEntity> findTriviaById(UUID uuid);

    Iterable<TriviaEntity> findAllTrivia();
}

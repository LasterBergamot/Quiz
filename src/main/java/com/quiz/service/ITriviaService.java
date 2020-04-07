package com.quiz.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.repository.entity.trivia.TriviaEntity;

public interface ITriviaService {

    void saveTrivia(TriviaDTO triviaDTO);

    void saveAllTrivia(List<OpenTriviaDatabaseResponse> openTriviaDatabaseResponses);

    Trivia findTriviaById(UUID uuid);

    Optional<TriviaEntity> findTriviaEntityById(String uuid);

    List<Trivia> findAllTrivia();
}

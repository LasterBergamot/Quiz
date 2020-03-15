package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.repository.entity.TriviaEntity;
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
    public void saveTrivia(TriviaDTO triviaDTO) {
        triviaService.saveTrivia(triviaDTO);
    }

    @Override
    public void saveAllTrivia(List<TriviaDTO> triviaDTOs) {
        triviaService.saveAllTrivia(triviaDTOs);
    }

    @Override
    public void printAllTrivia(List<TriviaDTO> triviaDTOs) {
        triviaService.printAllTrivia(triviaDTOs);
    }

    @Override
    public Optional<TriviaEntity> findTriviaById(UUID uuid) {
        return triviaService.findTriviaById(uuid);
    }

    @Override
    public Iterable<TriviaEntity> findAllTrivia() {
        return triviaService.findAllTrivia();
    }
}

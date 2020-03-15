package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.domain.trivia.dto.TriviaDTOTransformer;
import com.quiz.repository.TriviaRepository;
import com.quiz.repository.entity.TriviaEntity;
import com.quiz.service.ITriviaService;

@Service
public class TriviaService implements ITriviaService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TriviaService.class);

    private TriviaRepository triviaRepository;
    private TriviaDTOTransformer triviaDTOTransformer;

    @Autowired
    TriviaService(TriviaRepository triviaRepository, TriviaDTOTransformer triviaDTOTransformer) {
        this.triviaRepository = triviaRepository;
        this.triviaDTOTransformer = triviaDTOTransformer;
    }

    @Override
    public void saveTrivia(TriviaDTO triviaDTO) {
        LOGGER.info("Saving TriviaEntity");
        triviaRepository.save(triviaDTOTransformer.transformTriviaDTOToTriviaEntity(triviaDTO));
    }

    @Override
    public void saveAllTrivia(List<TriviaDTO> triviaDTOs) {
        LOGGER.info("Saving all TriviaEntities");
        triviaRepository.saveAll(triviaDTOTransformer.transformTriviaDTOListToTriviaEntityList(triviaDTOs));
    }

    @Override
    public void printAllTrivia(List<TriviaDTO> triviaDTOs) {
        triviaDTOTransformer.transformTriviaDTOListToTriviaList(triviaDTOs).forEach(System.out::println);
    }

    @Override
    public Optional<TriviaEntity> findTriviaById(UUID uuid) {
        return triviaRepository.findById(uuid);
    }

    @Override
    public Iterable<TriviaEntity> findAllTrivia() {
        Iterable<TriviaEntity> triviaEntities = triviaRepository.findAll();

        for (TriviaEntity triviaEntity : triviaEntities) {
            System.out.println(triviaDTOTransformer.transformTriviaDTOToTrivia(triviaEntity.getTriviaDTO()));
        }

        return triviaEntities;
    }
}

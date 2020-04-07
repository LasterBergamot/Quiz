package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.hibernate.HibernateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.domain.trivia.transformer.TriviaTransformer;
import com.quiz.repository.trivia.TriviaRepository;
import com.quiz.repository.entity.trivia.TriviaEntity;
import com.quiz.service.ITriviaService;

@Service
public class TriviaService implements ITriviaService {

    private final static Logger LOGGER = LoggerFactory.getLogger(TriviaService.class);

    private TriviaRepository triviaRepository;
    private TriviaTransformer triviaTransformer;

    @Autowired
    TriviaService(TriviaRepository triviaRepository, TriviaTransformer triviaTransformer) {
        this.triviaRepository = triviaRepository;
        this.triviaTransformer = triviaTransformer;
    }

    @Override
    public void saveTrivia(TriviaDTO triviaDTO) {
        LOGGER.info("Saving TriviaEntity");
        triviaRepository.save(triviaTransformer.transformTriviaDTOToTriviaEntity(triviaDTO));
    }

    @Override
    public void saveAllTrivia(List<OpenTriviaDatabaseResponse> openTriviaDatabaseResponses) {
        LOGGER.info("Saving all TriviaEntities");

        openTriviaDatabaseResponses.forEach(openTriviaDatabaseResponse ->
                triviaRepository.saveAll(triviaTransformer.transformTriviaDTOListToTriviaEntityList(openTriviaDatabaseResponse.getResults())));
    }

    @Override
    public Trivia findTriviaById(UUID uuid) {
        Optional<TriviaEntity> optionalTriviaEntity = triviaRepository.findById(uuid);

        return optionalTriviaEntity.isPresent() ? triviaTransformer.transformTriviaEntityToTrivia(optionalTriviaEntity.get()) : new Trivia();
    }

    @Override
    public Optional<TriviaEntity> findTriviaEntityById(String uuid) {
        return triviaRepository.findById(UUID.fromString(uuid));
    }

    @Override
    public List<Trivia> findAllTrivia() {
        List<TriviaEntity> triviaEntities = new ArrayList<>();

       try {
           triviaEntities = StreamSupport
                   .stream(triviaRepository.findAll().spliterator(), false)
                   .collect(Collectors.toList());
       } catch (HibernateException e) {
           LOGGER.error("{} - HibernateException has been caught", this.getClass().getSimpleName());
           e.printStackTrace();
       }

        return triviaTransformer.transformTriviaEntityListToTriviaList(triviaEntities);
    }
}

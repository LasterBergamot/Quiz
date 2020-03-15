package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.domain.trivia.dto.TriviaDTOTransformer;
import com.quiz.repository.TriviaRepository;
import com.quiz.repository.entity.trivia.TriviaEntity;
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
    public Trivia findTriviaById(UUID uuid) {
        Optional<TriviaEntity> optionalTriviaEntity = triviaRepository.findById(uuid);

        return optionalTriviaEntity.isPresent() ? triviaDTOTransformer.transformTriviaDTOToTrivia(optionalTriviaEntity.get().getTriviaDTO()) : new Trivia();
    }

    @Override
    public List<Trivia> findAllTrivia() {
        List<TriviaEntity> triviaEntities = StreamSupport
                .stream(triviaRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return triviaEntities.stream()
                .map(triviaEntity -> triviaDTOTransformer.transformTriviaDTOToTrivia(triviaEntity.getTriviaDTO()))
                .collect(Collectors.toList());
    }
}

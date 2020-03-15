package com.quiz.repository.trivia;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quiz.repository.entity.trivia.TriviaEntity;

public interface TriviaRepository extends CrudRepository<TriviaEntity, UUID> {}

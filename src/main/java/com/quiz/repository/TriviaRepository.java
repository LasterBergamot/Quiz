package com.quiz.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quiz.repository.entity.trivia.TriviaEntity;

public interface TriviaRepository extends CrudRepository<TriviaEntity, UUID> {}

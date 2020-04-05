package com.quiz.repository.answer;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quiz.repository.entity.answer.AnswerEntity;

public interface AnswerRepository extends CrudRepository<AnswerEntity, UUID> {
}

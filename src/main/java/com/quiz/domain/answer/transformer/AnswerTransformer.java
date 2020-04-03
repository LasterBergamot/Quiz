package com.quiz.domain.answer.transformer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quiz.domain.answer.Answer;
import com.quiz.domain.trivia.transformer.TriviaTransformer;
import com.quiz.repository.entity.answer.AnswerEntity;

@Component
public class AnswerTransformer {

    private TriviaTransformer triviaTransformer;

    public AnswerTransformer() {}

    @Autowired
    AnswerTransformer(TriviaTransformer triviaTransformer) {
        this.triviaTransformer = triviaTransformer;
    }

    public List<AnswerEntity> transformAnswersToAnswerEntities(List<Answer> answers) {
        return answers.stream().map(this::transformAnswerToAnswerEntity).collect(Collectors.toList());
    }

    public AnswerEntity transformAnswerToAnswerEntity(Answer answer) {
        return new AnswerEntity(answer.getSelectedAnswer(), answer.isAnsweredCorrectly());
    }

    public List<Answer> transformAnswerEntitiesToAnswers(List<AnswerEntity> answerEntities) {
        return Optional.ofNullable(answerEntities)
                .map(answerEntitiesFromOptional -> answerEntitiesFromOptional.stream().map(this::transformAnswerEntityToAnswer).collect(Collectors.toList()))
                .orElse(new ArrayList<>());
    }

    public Answer transformAnswerEntityToAnswer(AnswerEntity answerEntity) {
        return new Answer(answerEntity.getUuid(), triviaTransformer.transformTriviaDTOToTrivia(answerEntity.getTriviaEntity().getTriviaDTO()), answerEntity.getSelectedAnswer(),
                answerEntity.isAnsweredCorrectly());
    }
}

package com.quiz.domain.answer.transformer;

import java.util.List;
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
        return new AnswerEntity(triviaTransformer.transformTriviaToTriviaEntity(answer.getTrivia()), answer.isAnsweredCorrectly());
    }
}

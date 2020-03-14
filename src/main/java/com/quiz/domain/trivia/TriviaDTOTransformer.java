package com.quiz.domain.trivia;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.trivia.builder.TriviaBuilder;
import com.quiz.domain.type.Type;

@Component
public class TriviaDTOTransformer {

    public List<Trivia> transformTriviaDTOListToTriviaList(List<TriviaDTO> triviaDTOList) {
        return triviaDTOList.stream()
                .map(this::transformTriviaDTOToTrivia)
                .collect(Collectors.toList());
    }

    private Trivia transformTriviaDTOToTrivia(TriviaDTO triviaDTO) {
        return new TriviaBuilder()
                .withCategory(Category.valueOf(triviaDTO.getCategory()))
                .withType(Type.valueOf(triviaDTO.getType()))
                .withDifficulty(Difficulty.valueOf(triviaDTO.getType()))
                .withQuestion(triviaDTO.getQuestion())
                .withCorrectAnswer(triviaDTO.getCorrectAnswer())
                .withIncorrectAnswers(triviaDTO.getIncorrectAnswers())
                .build();
    }
}

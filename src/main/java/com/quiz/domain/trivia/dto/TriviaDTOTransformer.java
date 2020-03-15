package com.quiz.domain.trivia.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.builder.TriviaBuilder;
import com.quiz.domain.type.Type;
import com.quiz.repository.entity.TriviaEntity;

@Component
public class TriviaDTOTransformer {

    public List<Trivia> transformTriviaDTOListToTriviaList(List<TriviaDTO> triviaDTOList) {
        return triviaDTOList.stream()
                .map(this::transformTriviaDTOToTrivia)
                .collect(Collectors.toList());
    }

    private Trivia transformTriviaDTOToTrivia(TriviaDTO triviaDTO) {
        return new TriviaBuilder()
                .withCategory(getCategoryFromTriviaDTO(triviaDTO.getCategory()))
                .withType(getTypeFromTriviaDTO(triviaDTO.getType()))
                .withDifficulty(getDifficultyFromTriviaDTO(triviaDTO.getDifficulty()))
                .withQuestion(triviaDTO.getQuestion())
                .withCorrectAnswer(triviaDTO.getCorrectAnswer())
                .withIncorrectAnswers(triviaDTO.getIncorrectAnswers())
                .build();
    }

    private Category getCategoryFromTriviaDTO(String categoryFromTriviaDTO) {
        for (Category category : Category.values()) {
            if (category.getName().equals(categoryFromTriviaDTO)) {
                return category;
            }
        }

        return null;
    }

    private Type getTypeFromTriviaDTO(String typeFromTriviaDTO) {
        for (Type type : Type.values()) {
            if (type.getType().equals(typeFromTriviaDTO)) {
                return type;
            }
        }

        return null;
    }

    private Difficulty getDifficultyFromTriviaDTO(String difficultyFromTriviaDTO) {
        for (Difficulty difficulty : Difficulty.values()) {
            if (difficulty.getDifficulty().equals(difficultyFromTriviaDTO)) {
                return difficulty;
            }
        }

        return null;
    }

    public List<TriviaEntity> transformTriviaDTOListToTriviaEntityList(List<TriviaDTO> triviaDTOList) {
        return triviaDTOList.stream()
                .map(this::transformTriviaDTOToTriviaEntity)
                .collect(Collectors.toList());
    }

    public TriviaEntity transformTriviaDTOToTriviaEntity(TriviaDTO triviaDTO) {
        return new TriviaEntity(triviaDTO);
    }

}

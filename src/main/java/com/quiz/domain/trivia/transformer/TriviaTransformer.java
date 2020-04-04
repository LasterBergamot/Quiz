package com.quiz.domain.trivia.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.quiz.controller.quiz.model.QuizPageTriviaModel;
import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.builder.TriviaBuilder;
import com.quiz.domain.trivia.dto.TriviaDTO;
import com.quiz.domain.type.Type;
import com.quiz.repository.entity.trivia.TriviaEntity;

@Component
public class TriviaTransformer {

    public List<Trivia> transformTriviaDTOListToTriviaList(List<TriviaDTO> triviaDTOList) {
        return triviaDTOList.stream()
                .map(this::transformTriviaDTOToTrivia)
                .collect(Collectors.toList());
    }

    public Trivia transformTriviaDTOToTrivia(TriviaDTO triviaDTO) {
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

    public TriviaEntity transformTriviaToTriviaEntity(Trivia trivia) {
        return new TriviaEntity(transformTriviaToTriviaDTO(trivia));
    }

    public TriviaDTO transformTriviaToTriviaDTO(Trivia trivia) {
        TriviaDTO triviaDTO = new TriviaDTO();

        triviaDTO.setCategory(trivia.getCategory().getName());
        triviaDTO.setType(trivia.getType().getType());
        triviaDTO.setDifficulty(trivia.getDifficulty().getDifficulty());
        triviaDTO.setQuestion(trivia.getQuestion());
        triviaDTO.setCorrectAnswer(trivia.getCorrectAnswer());
        triviaDTO.setIncorrectAnswers(trivia.getIncorrectAnswers());

        return triviaDTO;
    }

    public List<QuizPageTriviaModel> transformTriviaListToQuizPageTriviaModelList(List<Trivia> triviaList) {
        return triviaList.stream().map(this::transformTriviaToQuizPageTriviaModel).collect(Collectors.toList());
    }

    private QuizPageTriviaModel transformTriviaToQuizPageTriviaModel(Trivia trivia) {
        QuizPageTriviaModel quizPageTriviaModel = new QuizPageTriviaModel();

        quizPageTriviaModel.setUuid(trivia.getUuid());
        quizPageTriviaModel.setCategory(trivia.getCategory());
        quizPageTriviaModel.setType(trivia.getType());
        quizPageTriviaModel.setDifficulty(trivia.getDifficulty());
        quizPageTriviaModel.setQuestion(trivia.getQuestion());
        quizPageTriviaModel.setCorrectAnswer(trivia.getCorrectAnswer());

        List<String> allAnswers = trivia.getIncorrectAnswers();
        allAnswers.add(trivia.getCorrectAnswer());
        quizPageTriviaModel.setAllAnswers(allAnswers);

        return quizPageTriviaModel;
    }

    public List<Trivia> transformTriviaEntityListToTriviaList(List<TriviaEntity> triviaEntityList) {
        return triviaEntityList.stream().map(this::transformTriviaEntityToTrivia).collect(Collectors.toList());
    }

    public Trivia transformTriviaEntityToTrivia(TriviaEntity triviaEntity) {
        Trivia trivia = transformTriviaDTOToTrivia(triviaEntity.getTriviaDTO());
        trivia.setUuid(triviaEntity.getUuid());

        return trivia;
    }
}

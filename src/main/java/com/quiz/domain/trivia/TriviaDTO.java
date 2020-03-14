package com.quiz.domain.trivia;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class TriviaDTO {

    private String category;
    private String type;
    private String difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    @JsonCreator
    public TriviaDTO(@JsonProperty("category") String category, @JsonProperty("type") String type, @JsonProperty("difficulty") String difficulty,
            @JsonProperty("question") String question, @JsonProperty("correct_answer")String correctAnswer, @JsonProperty("incorrect_answers") List<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }
}

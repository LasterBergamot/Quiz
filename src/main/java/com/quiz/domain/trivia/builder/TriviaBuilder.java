package com.quiz.domain.trivia.builder;

import java.util.List;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.type.Type;

public class TriviaBuilder {

    private Category category;
    private Type type;
    private Difficulty difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public TriviaBuilder withCategory(Category category) {
        this.category = category;
        return this;
    }

    public TriviaBuilder withType(Type type) {
        this.type = type;
        return this;
    }

    public TriviaBuilder withDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public TriviaBuilder withQuestion(String question) {
        this.question = question;
        return this;
    }

    public TriviaBuilder withCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
        return this;
    }

    public TriviaBuilder withIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
        return this;
    }

    public Trivia build() {
        return new Trivia(category, type, difficulty, question, correctAnswer, incorrectAnswers);
    }
}

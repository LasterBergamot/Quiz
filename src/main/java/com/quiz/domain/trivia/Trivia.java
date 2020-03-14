package com.quiz.domain.trivia;

import java.util.List;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.type.Type;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Trivia {

    private Category category;
    private Type type;
    private Difficulty difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private boolean answeredCorrectly;

    public Trivia(Category category, Type type, Difficulty difficulty, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        this.answeredCorrectly = false;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }
}

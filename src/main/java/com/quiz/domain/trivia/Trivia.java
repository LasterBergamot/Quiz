package com.quiz.domain.trivia;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Component;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.type.Type;

@Component
public class Trivia {

    private Category category;
    private Type type;
    private Difficulty difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;
    private boolean answeredCorrectly;

    public Trivia() {}

    public Trivia(Category category, Type type, Difficulty difficulty, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
        this.answeredCorrectly = false;
    }

    public Category getCategory() {
        return category;
    }

    public Type getType() {
        return type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public boolean isAnsweredCorrectly() {
        return answeredCorrectly;
    }

    public void setAnsweredCorrectly(boolean answeredCorrectly) {
        this.answeredCorrectly = answeredCorrectly;
    }

    @Override
    public String toString() {
        return "TriviaEntity{" + "category=" + category + ", type=" + type + ", difficulty=" + difficulty + ", question='" + question + '\'' + ", correctAnswer='"
                + correctAnswer + '\'' + ", incorrectAnswers=" + incorrectAnswers + ", answeredCorrectly=" + answeredCorrectly + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Trivia trivia = (Trivia) o;
        return answeredCorrectly == trivia.answeredCorrectly && category == trivia.category && type == trivia.type && difficulty == trivia.difficulty && Objects
                .equals(question, trivia.question) && Objects.equals(correctAnswer, trivia.correctAnswer) && Objects
                .equals(incorrectAnswers, trivia.incorrectAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(category, type, difficulty, question, correctAnswer, incorrectAnswers, answeredCorrectly);
    }
}

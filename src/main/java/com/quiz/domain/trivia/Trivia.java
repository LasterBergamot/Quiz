package com.quiz.domain.trivia;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.type.Type;

public class Trivia {

    private UUID uuid;
    private Category category;
    private Type type;
    private Difficulty difficulty;
    private String question;
    private String correctAnswer;
    private List<String> incorrectAnswers;

    public Trivia() {}

    public Trivia(Category category, Type type, Difficulty difficulty, String question, String correctAnswer, List<String> incorrectAnswers) {
        this.category = category;
        this.type = type;
        this.difficulty = difficulty;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getIncorrectAnswers() {
        return incorrectAnswers;
    }

    public void setIncorrectAnswers(List<String> incorrectAnswers) {
        this.incorrectAnswers = incorrectAnswers;
    }

    @Override
    public String toString() {
        return "Trivia{" + "uuid=" + uuid + ", category=" + category + ", type=" + type + ", difficulty=" + difficulty + ", question='" + question + '\''
                + ", correctAnswer='" + correctAnswer + '\'' + ", incorrectAnswers=" + incorrectAnswers + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Trivia trivia = (Trivia) o;
        return Objects.equals(uuid, trivia.uuid) && category == trivia.category && type == trivia.type && difficulty == trivia.difficulty && Objects
                .equals(question, trivia.question) && Objects.equals(correctAnswer, trivia.correctAnswer) && Objects
                .equals(incorrectAnswers, trivia.incorrectAnswers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, category, type, difficulty, question, correctAnswer, incorrectAnswers);
    }
}

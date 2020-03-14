package com.quiz.domain.difficulty;

public enum Difficulty {

    EASY("easy", 1),
    MEDIUM("medium", 2),
    HARD("hard", 3);

    private String difficulty;
    private int point;

    Difficulty() {}

    Difficulty(String difficulty, int point) {
        this.difficulty = difficulty;
        this.point = point;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public int getPoint() {
        return point;
    }
}

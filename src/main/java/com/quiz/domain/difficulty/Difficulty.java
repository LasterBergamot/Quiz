package com.quiz.domain.difficulty;

import lombok.Getter;

@Getter
public enum Difficulty {

    EASY("easy", 1),
    MEDIUM("medium", 2),
    HARD("hard", 3);

    private final String difficulty;
    private final int point;

    Difficulty(String difficulty, int point) {
        this.difficulty = difficulty;
        this.point = point;
    }
}

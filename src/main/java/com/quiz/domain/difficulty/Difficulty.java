package com.quiz.domain.difficulty;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Difficulty {

    EASY("easy", 1),
    MEDIUM("medium", 2),
    HARD("hard", 3);

    private String difficulty;
    private int point;

    Difficulty(String difficulty, int point) {
        this.difficulty = difficulty;
        this.point = point;
    }
}

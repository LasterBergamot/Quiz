package com.quiz.util;

import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.type.Type;

public class Formatter {

    public static String formatType(Type type) {
        String result = "";

        switch (type) {
        case TRUE_FALSE:
            result = "Yes/No";
            break;
        case MULTIPLE_CHOICE:
            result = "Multiple choice";
            break;
        default:
            break;
        }

        return result;
    }

    public static String formatDifficulty(Difficulty difficulty) {
        String result = "";

        switch (difficulty) {
        case EASY:
            result = "Easy";
            break;
        case MEDIUM:
            result = "Medium";
            break;
        case HARD:
            result = "Hard";
            break;
        default:
            break;
        }

        return result;
    }

    public static String formatAnsweredCorrectly(boolean answeredCorrectly) {
        return answeredCorrectly ? "Yes": "No";
    }
}

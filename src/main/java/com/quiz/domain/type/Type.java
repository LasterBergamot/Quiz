package com.quiz.domain.type;

import lombok.Getter;

@Getter
public enum Type {

    TRUE_FALSE("boolean"),
    MULTIPLE_CHOICE("multiple");

    private final String type;

    Type(String type) {
        this.type = type;
    }
}

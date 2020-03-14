package com.quiz.domain.type;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum Type {

    TRUE_FALSE("boolean"),
    MULTIPLE_CHOICE("multiple");

    private String type;

    Type(String type) {
        this.type = type;
    }
}

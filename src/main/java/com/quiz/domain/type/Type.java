package com.quiz.domain.type;

public enum Type {

    TRUE_FALSE("boolean"),
    MULTIPLE_CHOICE("multiple");

    private String type;

    Type() {}

    Type(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

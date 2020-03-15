package com.quiz.domain.trivia;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TriviaDTOList {

    private String responseCode;
    private List<TriviaDTO> triviaDTOList;

    public TriviaDTOList() {
        this.triviaDTOList = new ArrayList<>();
    }

    @JsonCreator
    public TriviaDTOList(@JsonProperty("response_code") String responseCode, @JsonProperty("results") List<TriviaDTO> triviaDTOList) {
        this.responseCode = responseCode;
        this.triviaDTOList = triviaDTOList;
    }

    public List<TriviaDTO> getTriviaDTOList() {
        return triviaDTOList;
    }

    public void setTriviaDTOList(List<TriviaDTO> triviaDTOList) {
        this.triviaDTOList = triviaDTOList;
    }
}

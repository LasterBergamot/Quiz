package com.quiz.service;

import java.util.List;

import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.domain.answer.Answer;

public interface IResultService {
    ResultModel createResultModelFromAnswers(List<Answer> answers);
}

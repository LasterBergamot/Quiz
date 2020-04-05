package com.quiz.service;

import java.util.List;
import java.util.UUID;

import com.quiz.controller.quiz.model.QuizPageAnswerModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.player.Player;

public interface IAnswerService {
    List<Answer> createRecentAnswers(List<QuizPageAnswerModel> quizPageAnswerModelList);
    List<Answer> saveAnswers(List<Answer> answers, Player player);
    List<Answer> findAllAnswersByPlayer(UUID uuid);
}

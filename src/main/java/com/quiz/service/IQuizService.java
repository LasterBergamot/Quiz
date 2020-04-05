package com.quiz.service;

import java.util.List;

import com.quiz.controller.quiz.model.QuizPageAnswerModel;
import com.quiz.controller.quiz.model.QuizPageTriviaModel;
import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.player.Player;

public interface IQuizService {

    List<QuizPageTriviaModel> getQuizPageTriviaModels(int numberOfTrivia);
    List<Answer> createRecentAnswers(List<QuizPageAnswerModel> quizPageAnswerModelList);
    ResultModel createResultModelFromAnswers(List<Answer> answers);
    List<Answer> saveAnswers(List<Answer> answers, Player player);
    Player findPlayerByUUID(String uuid);
}

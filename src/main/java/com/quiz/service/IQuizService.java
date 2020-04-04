package com.quiz.service;

import java.util.List;

import com.quiz.controller.quiz.model.QuizPageTriviaModel;
import com.quiz.domain.player.Player;

public interface IQuizService {

    List<QuizPageTriviaModel> getQuizPageTriviaModels(int numberOfTrivia);
    Player findPlayerByUUID(String uuid);
    void calculateResults();
}

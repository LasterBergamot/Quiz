package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.quiz.controller.quiz.model.AnswerResultModel;
import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.trivia.Trivia;
import com.quiz.service.IResultService;
import com.quiz.util.Formatter;

@Service
public class ResultService implements IResultService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    @Override
    public ResultModel createResultModelFromAnswers(List<Answer> answers) {
        LOGGER.info("{} - Creating ResultModel from {} answers", this.getClass().getSimpleName(), answers.size());
        List<AnswerResultModel> answerResultModelList = new ArrayList<>();
        int gainedPoints = 0;

        for (Answer answer : answers) {
            Trivia trivia = answer.getTrivia();

            Difficulty difficulty = trivia.getDifficulty();
            boolean answeredCorrectly = answer.isAnsweredCorrectly();
            int points = difficulty.getPoint();

            gainedPoints += answeredCorrectly ? points : 0;

            answerResultModelList.add(new AnswerResultModel(trivia.getCategory().getName(), Formatter.formatType(trivia.getType()),
                    Formatter.formatDifficulty(trivia.getDifficulty()), trivia.getQuestion(), trivia.getCorrectAnswer(),
                    answer.getSelectedAnswer(),Formatter.formatAnsweredCorrectly(answeredCorrectly), String.valueOf(points)));
        }

        return new ResultModel(answerResultModelList, String.valueOf(gainedPoints));
    }
}

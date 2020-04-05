package com.quiz.service.impl;

import static com.quiz.domain.difficulty.Difficulty.*;
import static com.quiz.domain.difficulty.Difficulty.EASY;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.controller.quiz.QuizController;
import com.quiz.controller.quiz.model.AnswerResultModel;
import com.quiz.controller.quiz.model.QuizPageAnswerModel;
import com.quiz.controller.quiz.model.QuizPageTriviaModel;
import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.player.Player;
import com.quiz.domain.trivia.Trivia;
import com.quiz.domain.trivia.transformer.TriviaTransformer;
import com.quiz.domain.type.Type;
import com.quiz.service.IAnswerService;
import com.quiz.service.IPlayerService;
import com.quiz.service.IQuizService;
import com.quiz.service.ITriviaService;

@Service
public class QuizService implements IQuizService {

    private final static Logger LOGGER = LoggerFactory.getLogger(QuizController.class);

    private ITriviaService triviaService;
    private IPlayerService playerService;
    private IAnswerService answerService;

    private TriviaTransformer triviaTransformer;

    @Autowired
    public QuizService(ITriviaService triviaService, IPlayerService playerService, TriviaTransformer triviaTransformer, IAnswerService answerService) {
        this.triviaService = triviaService;
        this.playerService = playerService;
        this.triviaTransformer = triviaTransformer;
        this.answerService = answerService;
    }

    @Override
    public List<QuizPageTriviaModel> getQuizPageTriviaModels(int numberOfTrivia) {
        List<Trivia> allTrivia = new ArrayList<>(new HashSet<>(triviaService.findAllTrivia()));

        if (numberOfTrivia > allTrivia.size()) {
            throw new IllegalArgumentException("The number of trivia you are trying to get is larger than the number of trivia in the database!");
        }

        Collections.shuffle(allTrivia);

        return triviaTransformer.transformTriviaListToQuizPageTriviaModelList(allTrivia.stream().limit(numberOfTrivia).collect(Collectors.toList()));
    }

    @Override
    public List<Answer> createRecentAnswers(List<QuizPageAnswerModel> quizPageAnswerModelList) {
        LOGGER.info("{} - Creating {} recent answers", this.getClass().getSimpleName(), quizPageAnswerModelList.size());
        return answerService.createRecentAnswers(quizPageAnswerModelList);
    }

    @Override
    public ResultModel createResultModelFromRecentAnswers(List<Answer> recentAnswers) {
        List<AnswerResultModel> answerResultModelList = new ArrayList<>();
        int gainedPoints = 0;

        for (Answer answer : recentAnswers) {
            Trivia trivia = answer.getTrivia();

            Difficulty difficulty = trivia.getDifficulty();
            boolean answeredCorrectly = answer.isAnsweredCorrectly();
            int points = difficulty.getPoint();

            gainedPoints += answeredCorrectly ? points : 0;

            answerResultModelList.add(new AnswerResultModel(trivia.getCategory().getName(), formatType(trivia.getType()),
                    formatDifficulty(trivia.getDifficulty()), trivia.getQuestion(), trivia.getCorrectAnswer(),
                    answer.getSelectedAnswer(),formatAnsweredCorrectly(answeredCorrectly), String.valueOf(points)));
        }

        return new ResultModel(answerResultModelList, String.valueOf(gainedPoints));
    }

    private String formatType(Type type) {
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

    private String formatDifficulty(Difficulty difficulty) {
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

    private String formatAnsweredCorrectly(boolean answeredCorrectly) {
        return answeredCorrectly ? "Yes": "No";
    }

    @Override
    public List<Answer> saveAnswers(List<Answer> answers, Player player) {
        LOGGER.info("{} - Saving {} answers", this.getClass().getSimpleName(), answers.size());
        return answerService.saveAnswers(answers, player);
    }

    @Override
    public Player findPlayerByUUID(String uuid) {
        if (uuid == null) {
            throw new IllegalArgumentException("The given UUID is NULL!");
        }

        return playerService.findPlayerEntityByUuid(UUID.fromString(uuid));
    }

    @Override
    public void calculateResults() {
        // get a List of Answers
        // return with a model with the Answers and the points with them
    }
}

package com.quiz.service.impl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.answer.Answer;
import com.quiz.domain.category.Category;
import com.quiz.domain.difficulty.Difficulty;
import com.quiz.domain.player.Player;
import com.quiz.domain.statistics.QuestionPointAnsweredOrNot;
import com.quiz.domain.statistics.QuestionWithGoodBadAnswers;
import com.quiz.domain.trivia.Trivia;
import com.quiz.service.IAnswerService;
import com.quiz.service.IPlayerService;
import com.quiz.service.IStatisticsService;
import com.quiz.service.ITriviaService;

@Service
public class StatisticsService implements IStatisticsService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    private IPlayerService playerService;
    private ITriviaService triviaService;
    private IAnswerService answerService;

    @Autowired
    public StatisticsService(IPlayerService playerService, ITriviaService triviaService, IAnswerService answerService) {
        this.playerService = playerService;
        this.triviaService = triviaService;
        this.answerService = answerService;
    }

    @Override
    public Integer calculateTheAverageOfPoints() {
        return null;
    }

    @Override
    public Map<Difficulty, Integer> getNumberOfQuestionsAnsweredByDifficulty() {
        return null;
    }

    @Override
    public Map<Category, Integer> getNumberOfQuestionsAnsweredByCategory() {
        LOGGER.info("{} - Getting number of questions answered by category", this.getClass().getSimpleName());
        Map<Category, Integer> numberOfQuestionsAnsweredByCategory = new HashMap<>();

        // making sure that there are only distinct values of trivia UUIDs
        Set<UUID> triviaUUIDs = answerService.findAllAnswers().stream().map(Answer::getTrivia).map(Trivia::getUuid).collect(Collectors.toSet());

        for (Trivia trivia : triviaUUIDs.stream().map(uuid -> triviaService.findTriviaById(uuid)).collect(Collectors.toList())) {
            Category category = trivia.getCategory();

            if (numberOfQuestionsAnsweredByCategory.containsKey(category)) {
                Integer numberOfQuestions = numberOfQuestionsAnsweredByCategory.get(category);
                numberOfQuestionsAnsweredByCategory.put(category, numberOfQuestions + 1);
            } else {
                numberOfQuestionsAnsweredByCategory.put(category, 1);
            }
        }

        return numberOfQuestionsAnsweredByCategory;
    }

    @Override
    public List<Player> createLeaderBoard() {
        LOGGER.info("{} - Creating the leaderboard", this.getClass().getSimpleName());
        return playerService.findAllPlayers().stream()
                .sorted(Comparator.comparingInt(Player::getGainedPoints)).collect(Collectors.toList());
    }

    @Override
    public List<QuestionWithGoodBadAnswers> getAllOfTheAnsweredQuestionsWithGoodAndBadAnswers() {
        return null;
    }

    @Override
    public List<String> getQuestionsByDifficulty(Difficulty difficulty) {
        LOGGER.info("{} - Getting questions by difficulty: {}", this.getClass().getSimpleName(), difficulty.getDifficulty());
        return triviaService.findAllTrivia().stream()
                .filter(trivia -> trivia.getDifficulty().equals(difficulty)).map(Trivia::getQuestion).collect(Collectors.toList());
    }

    @Override
    public Map<Category, List<QuestionPointAnsweredOrNot>> getAllOfTheQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot() {
        return null;
    }
}

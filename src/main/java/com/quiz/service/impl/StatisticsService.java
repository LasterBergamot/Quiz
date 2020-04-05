package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
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

    // Works
    @Override
    public Double calculateTheAverageOfPoints() {
        LOGGER.info("{} - Calculating the average of points", this.getClass().getSimpleName());
        return playerService.findAllPlayers().stream().mapToInt(Player::getGainedPoints).average().orElse(Double.NaN);
    }

    //TODO: Linkage Error
    @Override
    public Map<Difficulty, Integer> getNumberOfQuestionsAnsweredByDifficulty() {
        LOGGER.info("{} - Getting number of questions answered by difficulty", this.getClass().getSimpleName());
        Map<Difficulty, Integer> numberOfQuestionsAnsweredByDifficulty = new HashMap<>();

        // making sure that there are only distinct values of trivia UUIDs
        List<Answer> answers = answerService.findAllAnswers();
        Set<UUID> triviaUUIDs = answers.stream().map(Answer::getTrivia).map(Trivia::getUuid).collect(Collectors.toSet());

        for (Trivia trivia : triviaUUIDs.stream().map(uuid -> triviaService.findTriviaById(uuid)).collect(Collectors.toList())) {
            Difficulty difficulty = trivia.getDifficulty();

            if (numberOfQuestionsAnsweredByDifficulty.containsKey(difficulty)) {
                Integer numberOfQuestions = numberOfQuestionsAnsweredByDifficulty.get(difficulty);
                numberOfQuestionsAnsweredByDifficulty.put(difficulty, numberOfQuestions + 1);
            } else {
                numberOfQuestionsAnsweredByDifficulty.put(difficulty, 1);
            }
        }

        return numberOfQuestionsAnsweredByDifficulty;
    }

    // Works
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

    // Works
    @Override
    public List<Player> createLeaderBoard() {
        LOGGER.info("{} - Creating the leaderboard", this.getClass().getSimpleName());
        return playerService.findAllPlayers().stream()
                .sorted((p1, p2) -> Integer.compare(p2.getGainedPoints(), p1.getGainedPoints())).collect(Collectors.toList());
    }

    //TODO: NPE
    @Override
    public List<QuestionWithGoodBadAnswers> getAllOfTheAnsweredQuestionsWithGoodAndBadAnswers() {
        LOGGER.info("{} - Getting all answered questions with the number of good and bad answers", this.getClass().getSimpleName());
        Map<String, QuestionWithGoodBadAnswers> result = new HashMap<>();

        for (Answer answer : answerService.findAllAnswers()) {
            Trivia trivia = answer.getTrivia();
            String question = trivia.getQuestion();
            boolean answeredCorrectly = answer.isAnsweredCorrectly();

            if (result.containsKey(question)) {
                QuestionWithGoodBadAnswers questionWithGoodBadAnswers = result.get(question);

                if (answeredCorrectly) {
                    Integer numberOfGoodAnswers = questionWithGoodBadAnswers.getNumberOfGoodAnswers();
                    numberOfGoodAnswers = numberOfGoodAnswers + 1;
                    questionWithGoodBadAnswers.setNumberOfGoodAnswers(numberOfGoodAnswers);
                } else {
                    Integer numberOfBadAnswers = questionWithGoodBadAnswers.getNumberOfBadAnswers();
                    numberOfBadAnswers = numberOfBadAnswers + 1;
                    questionWithGoodBadAnswers.setNumberOfBadAnswers(numberOfBadAnswers);
                }

                result.put(question, questionWithGoodBadAnswers);
            } else {
                QuestionWithGoodBadAnswers questionWithGoodBadAnswers = new QuestionWithGoodBadAnswers();
                questionWithGoodBadAnswers.setQuestion(question);

                if (answeredCorrectly) {
                    questionWithGoodBadAnswers.setNumberOfGoodAnswers(1);
                } else {
                    questionWithGoodBadAnswers.setNumberOfBadAnswers(1);
                }

                result.put(question, questionWithGoodBadAnswers);
            }
        }

        return new ArrayList<>(result.values());
    }

    // Works
    @Override
    public List<String> getQuestionsByDifficulty(Difficulty difficulty) {
        LOGGER.info("{} - Getting questions by difficulty: {}", this.getClass().getSimpleName(), difficulty.getDifficulty());
        return triviaService.findAllTrivia().stream()
                .filter(trivia -> trivia.getDifficulty().equals(difficulty)).map(Trivia::getQuestion).collect(Collectors.toList());
    }

    // Works
    @Override
    public Map<Category, List<QuestionPointAnsweredOrNot>> getAllOfTheQuestionsForEachCategoryWithPointsAndIfTheyAreAnsweredOrNot() {
        LOGGER.info("{} - Getting questions for each category with points and if they are answered or not", this.getClass().getSimpleName());
        Map<Category, List<QuestionPointAnsweredOrNot>> result = new HashMap<>();
        List<Answer> answers = answerService.findAllAnswers();
        List<Trivia> triviaList = triviaService.findAllTrivia();

        for (Category category : triviaList.stream().map(Trivia::getCategory).collect(Collectors.toList())) {
            List<QuestionPointAnsweredOrNot> questionPointAnsweredOrNots = new ArrayList<>();
            List<Trivia> trivias = triviaList.stream().filter(trivia1 -> trivia1.getCategory().equals(category)).collect(Collectors.toList());

            for (Trivia trivia : trivias) {
                String question = trivia.getQuestion();
                Integer point = trivia.getDifficulty().getPoint();
                boolean answered = answers.stream().anyMatch(answer -> answer.getTrivia().getUuid().equals(trivia.getUuid()));

                questionPointAnsweredOrNots.add(new QuestionPointAnsweredOrNot(question, point, answered));
            }

            result.put(category, questionPointAnsweredOrNots);
        }

        return result;
    }
}

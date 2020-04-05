package com.quiz.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.controller.quiz.model.QuizPageAnswerModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.answer.transformer.AnswerTransformer;
import com.quiz.domain.player.Player;
import com.quiz.domain.trivia.Trivia;
import com.quiz.repository.answer.AnswerRepository;
import com.quiz.repository.entity.answer.AnswerEntity;
import com.quiz.repository.entity.player.PlayerEntity;
import com.quiz.repository.entity.trivia.TriviaEntity;
import com.quiz.service.IAnswerService;
import com.quiz.service.IPlayerService;
import com.quiz.service.ITriviaService;

@Service
public class AnswerService implements IAnswerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(AnswerService.class);

    private AnswerRepository answerRepository;
    private AnswerTransformer answerTransformer;
    private ITriviaService triviaService;
    private IPlayerService playerService;

    @Autowired
    public AnswerService(AnswerRepository answerRepository, AnswerTransformer answerTransformer, ITriviaService triviaService, IPlayerService playerService) {
        this.answerRepository = answerRepository;
        this.answerTransformer = answerTransformer;
        this.triviaService = triviaService;
        this.playerService = playerService;
    }

    @Override
    public List<Answer> createRecentAnswers(List<QuizPageAnswerModel> quizPageAnswerModelList) {
        LOGGER.info("{} - Creating {} recent answers", this.getClass().getSimpleName(), quizPageAnswerModelList.size());
        List<Answer> recentAnswers = new ArrayList<>();

        for (QuizPageAnswerModel quizPageAnswerModel : quizPageAnswerModelList) {
            Trivia trivia = triviaService.findTriviaById(UUID.fromString(quizPageAnswerModel.getTriviaUUID()));
            String selectedAnswer = quizPageAnswerModel.getSelectedAnswer();
            selectedAnswer = selectedAnswer == null ? "" : selectedAnswer;

            recentAnswers.add(new Answer(trivia, selectedAnswer, selectedAnswer.equals(trivia.getCorrectAnswer())));
        }

        return recentAnswers;
    }

    @Override
    public List<Answer> saveAnswers(List<Answer> answers, Player player) {
        LOGGER.info("{} Saving {} answers", this.getClass().getSimpleName(), answers.size());
        Optional<PlayerEntity> playerEntity = playerService.findPlayerEntityByUuid(player.getUuid().toString());

        List<AnswerEntity> answerEntities = answerTransformer.transformAnswersToAnswerEntities(answers);

        for (int index = 0; index < answers.size(); index++) {
            Answer answer = answers.get(index);
            AnswerEntity answerEntity = answerEntities.get(index);
            Optional<TriviaEntity> triviaEntity = triviaService.findTriviaEntityById(answer.getTrivia().getUuid().toString());

            playerEntity.ifPresent(answerEntity::setPlayerEntity);
            triviaEntity.ifPresent(answerEntity::setTriviaEntity);
        }

        List<AnswerEntity> answerEntitiesReadyToSave = StreamSupport
                .stream(answerRepository.saveAll(answerEntities).spliterator(), false)
                .collect(Collectors.toList());

        return answerTransformer.transformAnswerEntitiesToAnswers(answerEntitiesReadyToSave);
    }

    @Override
    public List<Answer> findAllAnswersByPlayer(UUID uuid) {
        LOGGER.info("{} - Finding all answers by player with UUID: {}", this.getClass().getSimpleName(), uuid);

        List<AnswerEntity> answerEntities = StreamSupport
                .stream(answerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return answerTransformer.transformAnswerEntitiesToAnswers(answerEntities).stream()
                .filter(answer -> answer.getUuid().equals(uuid)).collect(Collectors.toList());
    }

    @Override
    public List<Answer> findAllAnswers() {
        LOGGER.info("{} - Finding all answers", this.getClass().getSimpleName());
        List<AnswerEntity> answerEntities = StreamSupport
                .stream(answerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return answerTransformer.transformAnswerEntitiesToAnswers(answerEntities);
    }
}

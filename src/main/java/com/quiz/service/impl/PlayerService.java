package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.domain.answer.Answer;
import com.quiz.domain.answer.transformer.AnswerTransformer;
import com.quiz.domain.player.Player;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.repository.answer.AnswerRepository;
import com.quiz.repository.entity.answer.AnswerEntity;
import com.quiz.repository.entity.player.PlayerEntity;
import com.quiz.repository.player.PlayerRepository;
import com.quiz.service.IPlayerService;
import com.quiz.service.IResultService;

@Service
public class PlayerService implements IPlayerService {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerService.class);

    private PlayerRepository playerRepository;
    private AnswerRepository answerRepository;

    private IResultService resultService;

    private PlayerTransformer playerTransformer;
    private AnswerTransformer answerTransformer;

    @Autowired
    PlayerService(PlayerRepository playerRepository, PlayerTransformer playerTransformer, AnswerRepository answerRepository, IResultService resultService,
            AnswerTransformer answerTransformer) {
        this.playerRepository = playerRepository;
        this.playerTransformer = playerTransformer;
        this.answerRepository = answerRepository;
        this.resultService = resultService;
        this.answerTransformer = answerTransformer;
    }

    @Override
    public Player savePlayer(Player player) {
        LOGGER.info("{} - Saving player: {}", this.getClass().getSimpleName(), player);

        return playerTransformer.transformPlayerEntityToPlayer(playerRepository.save(playerTransformer.transformPlayerToPlayerEntity(player)));
    }

    @Override
    public Player modifyPlayer(PlayerModifyModel playerModifyModel) {
        LOGGER.info("{} - Modifying player: {}", this.getClass().getSimpleName(), playerModifyModel);

        return playerRepository.findById(playerModifyModel.getUuid()).map(playerEntity -> {
            playerEntity.setName(playerModifyModel.getName());
            playerEntity.setAge(playerModifyModel.getAge());

            return playerTransformer.transformPlayerEntityToPlayer(playerRepository.save(playerEntity));
        }).orElse(new Player());
    }

    @Override
    public void deletePlayerByUuid(UUID uuid) {
        LOGGER.info("{} - Deleting player with uuid: {}", this.getClass().getSimpleName(), uuid);

        playerRepository.deleteById(uuid);
    }

    @Override
    public Player findPlayerByUuid(UUID uuid) {
        LOGGER.info("{} - Finding player by uuid: {}", this.getClass().getSimpleName(), uuid);

        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findById(uuid);

        return optionalPlayerEntity.isPresent() ? playerTransformer.transformPlayerEntityToPlayer(optionalPlayerEntity.get()) : new Player();
    }

    @Override
    public Optional<PlayerEntity> findPlayerEntityByUuid(String uuid) {
        return playerRepository.findById(UUID.fromString(uuid));
    }

    @Override
    public List<Player> findAllPlayers() {
        LOGGER.info("{} - Finding all players", this.getClass().getSimpleName());

        List<PlayerEntity> playerEntities = StreamSupport
                .stream(playerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return playerEntities.stream()
                .map(playerEntity -> playerTransformer.transformPlayerEntityToPlayer(playerEntity))
                .collect(Collectors.toList());
    }

    @Override
    public ResultModel createResultModelFromAnswers(List<Answer> answers) {
        LOGGER.info("{} - Creating ResultModel from {} answers", this.getClass().getSimpleName(), answers.size());
        return resultService.createResultModelFromAnswers(answers);
    }

    @Override
    public List<Answer> findAllAnswersByPlayer(UUID uuid) {
        LOGGER.info("{} - Finding all answers by player with UUID: {}", this.getClass().getSimpleName(), uuid);
        List<AnswerEntity> answerEntities = StreamSupport
                .stream(answerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        List<AnswerEntity> answerEntitiesForPlayer = answerEntities.stream()
                .filter(answerEntity -> answerEntity.getPlayerEntity().getUuid().equals(uuid)).collect(Collectors.toList());

        return answerTransformer.transformAnswerEntitiesToAnswers(answerEntitiesForPlayer);
    }

    @Override
    public Player updatePlayerWithGainedPoints(UUID uuid, Integer gainedPoints) {
        return playerRepository.findById(uuid).map(playerEntity -> {
            Integer storedPoints = playerEntity.getGainedPoints();
            playerEntity.setGainedPoints(storedPoints + gainedPoints);

            return playerTransformer.transformPlayerEntityToPlayer(playerRepository.save(playerEntity));
        }).orElse(new Player());
    }
}

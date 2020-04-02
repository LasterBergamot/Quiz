package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.player.Player;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.repository.entity.player.PlayerEntity;
import com.quiz.repository.player.PlayerRepository;
import com.quiz.service.IPlayerService;

@Service
public class PlayerService implements IPlayerService {

    private PlayerRepository playerRepository;
    private PlayerTransformer playerTransformer;

    @Autowired PlayerService(PlayerRepository playerRepository, PlayerTransformer playerTransformer) {
        this.playerRepository = playerRepository;
        this.playerTransformer = playerTransformer;
    }

    @Override
    public void savePlayer(Player player) {
        playerRepository.save(playerTransformer.transformPlayerToPlayerEntity(player));
    }

    @Override
    public void deletePlayerByUuid(UUID uuid) {
        playerRepository.deleteById(uuid);
    }

    @Override
    public Player findPlayerByUuid(UUID uuid) {
        Optional<PlayerEntity> optionalPlayerEntity = playerRepository.findById(uuid);

        return optionalPlayerEntity.isPresent() ? playerTransformer.transformPlayerEntityToPlayer(optionalPlayerEntity.get()) : new Player();
    }

    @Override
    public List<Player> findAllPlayers() {
        List<PlayerEntity> playerEntities = StreamSupport
                .stream(playerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return playerEntities.stream()
                .map(playerEntity -> playerTransformer.transformPlayerEntityToPlayer(playerEntity))
                .collect(Collectors.toList());
    }
}

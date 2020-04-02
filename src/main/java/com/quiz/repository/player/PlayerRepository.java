package com.quiz.repository.player;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quiz.repository.entity.player.PlayerEntity;

public interface PlayerRepository extends CrudRepository<PlayerEntity, UUID> {}

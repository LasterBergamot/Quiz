package com.quiz.domain.player.transformer;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quiz.domain.answer.transformer.AnswerTransformer;
import com.quiz.domain.player.Player;
import com.quiz.domain.player.PlayerFormModel;
import com.quiz.repository.entity.player.PlayerEntity;

@Component
public class PlayerTransformer {

    private AnswerTransformer answerTransformer;

    public PlayerTransformer() {}

    @Autowired PlayerTransformer(AnswerTransformer answerTransformer) {
        this.answerTransformer = answerTransformer;
    }

    public PlayerEntity transformPlayerToPlayerEntity(Player player) {
        return new PlayerEntity(player.getName(), player.getAge(), answerTransformer.transformAnswersToAnswerEntities(player.getAnswers()));
    }

    public Player transformPlayerEntityToPlayer(PlayerEntity playerEntity) {
        return new Player(playerEntity.getUuid(), playerEntity.getName(), playerEntity.getAge(), answerTransformer.transformAnswerEntitiesToAnswers(playerEntity.getAnswerEntities()));
    }

    public Player transformPlayerFormModelToPlayer(PlayerFormModel playerFormModel) {
        return new Player(playerFormModel.getName(), playerFormModel.getAge(), new ArrayList<>());
    }
}

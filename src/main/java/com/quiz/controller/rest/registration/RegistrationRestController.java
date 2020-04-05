package com.quiz.controller.rest.registration;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.domain.player.Player;
import com.quiz.domain.player.PlayerFormModel;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.service.IPlayerService;

@RestController
public class RegistrationRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationRestController.class);

    private static final String POST_MAPPING_REGISTER_PLAYER = "/rest/register";

    private IPlayerService playerService;
    private PlayerTransformer playerTransformer;

    @Autowired
    public RegistrationRestController(IPlayerService playerService, PlayerTransformer playerTransformer) {
        this.playerService = playerService;
        this.playerTransformer = playerTransformer;
    }

    @PostMapping(POST_MAPPING_REGISTER_PLAYER)
    public Player registerPlayer(@Valid @RequestBody PlayerFormModel playerFormModel) {
        LOGGER.info("{} - Registering player: {}", this.getClass().getSimpleName(), playerFormModel);

        return playerService.savePlayer(playerTransformer.transformPlayerFormModelToPlayer(playerFormModel));
    }
}

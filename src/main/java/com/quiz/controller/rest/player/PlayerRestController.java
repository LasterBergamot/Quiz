package com.quiz.controller.rest.player;

import java.util.UUID;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.controller.rest.player.model.PlayerFillFormModel;
import com.quiz.controller.rest.registration.RegistrationRestController;
import com.quiz.domain.player.Player;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.service.IPlayerService;

@RestController
public class PlayerRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerRestController.class);

    private static final String POST_MAPPING_FILL_PLAYER_FIELDS = "/rest/fillPlayerFields";

    private IPlayerService playerService;
    private PlayerTransformer playerTransformer;

    @Autowired
    public PlayerRestController(IPlayerService playerService, PlayerTransformer playerTransformer) {
        this.playerService = playerService;
        this.playerTransformer = playerTransformer;
    }

    @PostMapping(POST_MAPPING_FILL_PLAYER_FIELDS)
    public Player getPlayerToFillTheFields(@Valid @RequestBody PlayerFillFormModel playerFillFormModel) {
        LOGGER.info("Got UUID: {}", playerFillFormModel);

        return playerService.findPlayerByUuid(playerFillFormModel.getPlayerUUID());
    }
}

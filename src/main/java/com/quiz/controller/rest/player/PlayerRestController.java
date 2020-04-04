package com.quiz.controller.rest.player;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.controller.rest.player.model.PlayerRestModel;
import com.quiz.domain.player.Player;
import com.quiz.domain.player.PlayerFormModel;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.service.IPlayerService;

@RestController
public class PlayerRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerRestController.class);

    private static final String POST_MAPPING_FILL_PLAYER_FIELDS = "/rest/fillPlayerFields";
    private static final String POST_MAPPING_MODIFY_PLAYER = "/rest/modifyPlayer";
    private static final String POST_MAPPING_DELETE_PLAYER = "/rest/deletePlayer";

    private IPlayerService playerService;
    private PlayerTransformer playerTransformer;

    @Autowired
    public PlayerRestController(IPlayerService playerService, PlayerTransformer playerTransformer) {
        this.playerService = playerService;
        this.playerTransformer = playerTransformer;
    }

    @PostMapping(POST_MAPPING_FILL_PLAYER_FIELDS)
    public Player fillFormFieldsWithPlayerData(@Valid @RequestBody PlayerRestModel playerRestModel) {
        LOGGER.info("Got UUID: {}", playerRestModel.getPlayerUUID());

        return playerService.findPlayerByUuid(playerRestModel.getPlayerUUID());
    }

    @PostMapping(POST_MAPPING_MODIFY_PLAYER)
    public Player modifyPlayer(@Valid @RequestBody PlayerModifyModel playerModifyModel) {
        LOGGER.info("Got PlayerModifyModel: {}", playerModifyModel);

        return playerService.modifyPlayer(playerModifyModel);
    }

    @PostMapping(POST_MAPPING_DELETE_PLAYER)
    public String deletePlayer(@Valid @RequestBody PlayerRestModel playerRestModel) {
        LOGGER.info("Got UUID: {}", playerRestModel.getPlayerUUID());

        playerService.deletePlayerByUuid(playerRestModel.getPlayerUUID());

        return "OK";
    }
}

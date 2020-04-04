package com.quiz.controller.rest.player;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.controller.rest.player.model.PlayerRestModel;
import com.quiz.domain.player.Player;
import com.quiz.service.IPlayerService;

@RestController
public class PlayerRestController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerRestController.class);

    private static final String POST_MAPPING_FILL_PLAYER_FIELDS = "/rest/fillPlayerFields";
    private static final String POST_MAPPING_MODIFY_PLAYER = "/rest/modifyPlayer";

    private IPlayerService playerService;

    @Autowired
    public PlayerRestController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping(POST_MAPPING_FILL_PLAYER_FIELDS)
    public Player fillFormFieldsWithPlayerData(@Valid @RequestBody PlayerRestModel playerRestModel) {
        LOGGER.info("{} - Got UUID: {}", this.getClass().getSimpleName(), playerRestModel.getPlayerUUID());

        return playerService.findPlayerByUuid(playerRestModel.getPlayerUUID());
    }

    @PostMapping(POST_MAPPING_MODIFY_PLAYER)
    public Player modifyPlayer(@Valid @RequestBody PlayerModifyModel playerModifyModel) {
        LOGGER.info("{} - Got PlayerModifyModel: {}", this.getClass().getSimpleName(), playerModifyModel);

        return playerService.modifyPlayer(playerModifyModel);
    }
}

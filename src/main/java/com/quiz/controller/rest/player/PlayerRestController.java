package com.quiz.controller.rest.player;

import java.util.List;
import java.util.UUID;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.controller.quiz.model.ResultModel;
import com.quiz.controller.rest.player.model.PlayerAnswersModel;
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
    public PlayerAnswersModel fillFormFieldsWithPlayerData(@Valid @RequestBody PlayerRestModel playerRestModel) {
        UUID playerUUID = playerRestModel.getPlayerUUID();
        LOGGER.info("{} - Got UUID: {}", this.getClass().getSimpleName(), playerUUID);
        Player player = playerService.findPlayerByUuid(playerUUID);
        ResultModel resultModel = playerService.createResultModelFromAnswers(playerService.findAllAnswersByPlayer(playerUUID));

        return new PlayerAnswersModel(player.getName(), player.getAge().toString(), resultModel.getAnswerResultModelList(),
                resultModel.getGainedPoints());
    }

    @PostMapping(POST_MAPPING_MODIFY_PLAYER)
    public Player modifyPlayer(@Valid @RequestBody PlayerModifyModel playerModifyModel) {
        LOGGER.info("{} - Got PlayerModifyModel: {}", this.getClass().getSimpleName(), playerModifyModel);

        return playerService.modifyPlayer(playerModifyModel);
    }

    @GetMapping("/rest/getAllPlayers")
    public List<Player> getAllPlayers() {
        return playerService.findAllPlayers();
    }
}

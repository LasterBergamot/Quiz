package com.quiz.controller.player;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.home.model.HomePageFormModel;
import com.quiz.controller.rest.player.model.PlayerModifyModel;
import com.quiz.controller.rest.player.model.PlayerRestModel;
import com.quiz.domain.player.Player;
import com.quiz.service.IPlayerService;

@Controller
public class PlayerController {

    private final static Logger LOGGER = LoggerFactory.getLogger(PlayerController.class);

    private static final String GET_MAPPING_PLAYER = "/player";

    private static final String VIEW_PLAYER = "player";

    private IPlayerService playerService;

    @Autowired PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(GET_MAPPING_PLAYER)
    public ModelAndView showPlayerPage() {
        LOGGER.info("Showing Player page");
        ModelAndView modelAndView = new ModelAndView(VIEW_PLAYER);

        // dropdown list with all of the players

        // when one is selected, fill a form with its data

        modelAndView.addObject("players", playerService.findAllPlayers());
        modelAndView.addObject("playerRestModel", new PlayerRestModel());
        return modelAndView;
    }

    @PostMapping("/deletePlayer")
    public String deletePlayer(@ModelAttribute("playerRestModel") PlayerRestModel playerRestModel) {
        LOGGER.info("Deleting player with uuid: {}", playerRestModel.getPlayerUUID());

        playerService.deletePlayerByUuid(playerRestModel.getPlayerUUID());

        return "redirect:/player";
    }
}

package com.quiz.controller.player;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.home.model.HomePageFormModel;
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
        return modelAndView;
    }

    public void saveModifiedPlayer() {
        // get the data from the form

        // save it to the database

        // reload the page (redirect maybe)
    }
}

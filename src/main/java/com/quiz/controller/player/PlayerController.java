package com.quiz.controller.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.service.IPlayerService;

@Controller
public class PlayerController {

    private static final String GET_MAPPING_PLAYER = "/player";

    private static final String VIEW_PLAYER = "player";

    private IPlayerService playerService;

    @Autowired PlayerController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(GET_MAPPING_PLAYER)
    public ModelAndView showPlayerPage() {
        // dropdown list with all of the players

        // when one is selected, fill a form with its data

        return new ModelAndView(VIEW_PLAYER);
    }

    public void saveModifiedPlayer() {
        // get the data from the form

        // save it to the database

        // reload the page (redirect maybe)
    }
}

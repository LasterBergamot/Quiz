package com.quiz.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.domain.player.PlayerFormModel;
import com.quiz.service.IPlayerService;

@Controller
public class RegistrationController {

    private final static String GET_MAPPING_REGISTRATION = "/registration";

    private final static String VIEW_REGISTRATION = "registration";

    private IPlayerService playerService;

    @Autowired
    RegistrationController(IPlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(GET_MAPPING_REGISTRATION)
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(VIEW_REGISTRATION);
    }

    public void registerPlayer(PlayerFormModel playerFormModel) {
        // save the player
        // transform playerFormModel to PlayerEntity
    }

    public String redirectToHomePage() {
        // the player presses a button to go back to the home page
        return "redirect:/";
    }

    public String redirectToQuizPage() {
        // the player presses a button to go to the quiz page
        // they want to play with the newly created player
        return "redirect:/quiz";
    }

}

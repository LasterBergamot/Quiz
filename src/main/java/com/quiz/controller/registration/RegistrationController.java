package com.quiz.controller.registration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.domain.player.PlayerFormModel;
import com.quiz.domain.player.transformer.PlayerTransformer;
import com.quiz.service.IPlayerService;

@Controller
public class RegistrationController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RegistrationController.class);

    private final static String GET_MAPPING_REGISTRATION = "/registration";

    private static final String POST_MAPPING_REGISTER_PLAYER = "/registerPlayer";

    private final static String VIEW_REGISTRATION = "registration";

    private IPlayerService playerService;
    private PlayerTransformer playerTransformer;

    @Autowired
    RegistrationController(IPlayerService playerService, PlayerTransformer playerTransformer) {
        this.playerTransformer = playerTransformer;
        this.playerService = playerService;
    }

    @GetMapping(GET_MAPPING_REGISTRATION)
    public ModelAndView showRegistrationPage() {
        LOGGER.info("{} - Showing Registration page", this.getClass().getSimpleName());

        ModelAndView modelAndView = new ModelAndView(VIEW_REGISTRATION);

        modelAndView.addObject("playerFormModel", new PlayerFormModel());
        return modelAndView;
    }
}

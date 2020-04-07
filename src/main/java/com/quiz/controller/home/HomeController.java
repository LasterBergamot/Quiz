package com.quiz.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.quiz.controller.home.model.HomePageFormModel;
import com.quiz.domain.player.Player;
import com.quiz.service.IHomeService;
import com.quiz.service.impl.TriviaService;

@Controller
public class HomeController {

    private final static Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    private final static String GET_MAPPING_HOME = "/";

    private static final String POST_MAPPING_PLAY_QUIZ = "/playQuiz";

    private final static String VIEW_HOME = "home";

    private IHomeService homeService;

    @Autowired HomeController(IHomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(GET_MAPPING_HOME)
    public ModelAndView showHomePage() {
        LOGGER.info("{} - Showing Home page", this.getClass().getSimpleName());
        ModelAndView modelAndView = new ModelAndView(VIEW_HOME);
        List<Player> alreadyExistingPlayers = homeService.findAllPlayers();

        modelAndView.addObject("homePageFormModel", new HomePageFormModel());
        modelAndView.addObject("players", alreadyExistingPlayers);

        return modelAndView;
    }

    @PostMapping(POST_MAPPING_PLAY_QUIZ)
    public RedirectView playQuizWithSelectedPlayer(@ModelAttribute("homePageFormModel") HomePageFormModel homePageFormModel, RedirectAttributes redirectAttributes) {
        String playerUUID = homePageFormModel.getPlayerUuid();
        LOGGER.info("{} - Player id: {}", this.getClass().getSimpleName(), playerUUID);

        if (playerUUID.equals("0")) {
            return new RedirectView("/");
        }

        redirectAttributes.addAttribute("playerUuid", playerUUID);

        return new RedirectView("/quiz/{playerUuid}");
    }
}

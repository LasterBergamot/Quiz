package com.quiz.controller.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.home.model.HomePageFormModel;
import com.quiz.domain.player.Player;
import com.quiz.service.IHomeService;

@Controller
public class HomeController {

    private final static String GET_MAPPING_HOME = "/";

    private static final String POST_MAPPING_PLAY_QUIZ = "/playQuiz";

    private final static String VIEW_HOME = "home";

    private IHomeService homeService;

    @Autowired HomeController(IHomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping(GET_MAPPING_HOME)
    public ModelAndView showHomePage() {
        ModelAndView modelAndView = new ModelAndView(VIEW_HOME);

        // populate the database with new trivia every time the app launches
       homeService.populateDatabase();

       // get all players from the database - can be empty
        List<Player> alreadyExistingPlayers = homeService.findAllPlayers();
        // then list them on the page

        modelAndView.addObject("players", alreadyExistingPlayers);
       return modelAndView;
    }

    @PostMapping(POST_MAPPING_PLAY_QUIZ)
    public String playQuizWithSelectedPlayer(HomePageFormModel homePageFormModel) {
        // the player selects and already existing player
        // then presses the quiz button
        return "redirect:/quiz";
    }

    public String redirectToRegistrationPage() {
        // the player wants to register a new player
        // presses the register button
        return "redirect:/registration";
    }
}

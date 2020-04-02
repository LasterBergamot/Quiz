package com.quiz.controller.home;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
        LOGGER.info("Showing Home page");
        ModelAndView modelAndView = new ModelAndView(VIEW_HOME);

        // populate the database with new trivia every time the app launches
//       homeService.populateDatabase();

       // get all players from the database - can be empty
        List<Player> alreadyExistingPlayers = homeService.findAllPlayers();
        // then list them on the page

        modelAndView.addObject("homePageFormModel", new HomePageFormModel());
        modelAndView.addObject("players", alreadyExistingPlayers);
       return modelAndView;
    }

    @PostMapping(POST_MAPPING_PLAY_QUIZ)
    public RedirectView playQuizWithSelectedPlayer(HomePageFormModel homePageFormModel, RedirectAttributes redirectAttributes) {
        LOGGER.info("Player id: {}", homePageFormModel.getPlayerUuid());

        // the player selects and already existing player
        // then presses the quiz button

        redirectAttributes.addAttribute("playerUuid", homePageFormModel.getPlayerUuid());
        return new RedirectView("quiz");
    }

    public String redirectToRegistrationPage() {
        // the player wants to register a new player
        // presses the register button
        return "redirect:/registration";
    }
}

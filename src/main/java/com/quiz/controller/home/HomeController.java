package com.quiz.controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.controller.rest.OpenTriviaDatabaseResponse;
import com.quiz.service.IHomeService;

@Controller
public class HomeController {

    private final String GET_MAPPING_HOME = "/";

    private final String VIEW_HOME = "home";

    private IHomeService homeService;
    private RestTemplate restTemplate;

    @Autowired HomeController(IHomeService homeService, RestTemplate restTemplate) {
        this.homeService = homeService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(GET_MAPPING_HOME)
    public ModelAndView showHomePage() {
       OpenTriviaDatabaseResponse openTriviaDatabaseResponse = restTemplate.getForObject("https://opentdb.com/api.php?amount=10", OpenTriviaDatabaseResponse.class);

       if (openTriviaDatabaseResponse != null) {
           homeService.printAllTrivia(openTriviaDatabaseResponse.getResults());
           homeService.saveAllTrivia(openTriviaDatabaseResponse.getResults());
           System.out.println();
           homeService.findAllTrivia();
       }

       return new ModelAndView(VIEW_HOME);
    }
}

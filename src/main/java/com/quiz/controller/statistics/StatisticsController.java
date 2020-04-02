package com.quiz.controller.statistics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.service.IStatisticsService;
import com.quiz.service.ITriviaService;

@Controller
public class StatisticsController {

    private static final String GET_MAPPING_STATISTICS = "/statistics";

    private static final String VIEW_STATISTICS = "statistics";

    private IStatisticsService statisticsService;
    private ITriviaService triviaService;

    @Autowired
    StatisticsController(IStatisticsService statisticsService, ITriviaService triviaService) {
        this.statisticsService = statisticsService;
        this.triviaService = triviaService;
    }

    @GetMapping(GET_MAPPING_STATISTICS)
    public ModelAndView showStatisticsPage() {
        // get the number of questions in the database
            // find all trivia

        // get every answered question for each player (dropdown list)
            // get all answer object for each player

        // get every point from each player
            // calculate depending on the answers OR create a Statistics table to keep track of everything (update after each game)

        // get the number of every correctly and wrongly answered question
        // get average of:
            // answered questions + correctly and wrongly answered ones
            // points

        // put them into one model

        return new ModelAndView(VIEW_STATISTICS);
    }
}

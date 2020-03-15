package com.quiz.controller.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.domain.user.UserFormModel;
import com.quiz.service.IUserService;

@Controller
public class RegistrationController {

    private final static String GET_MAPPING_REGISTRATION = "/registration";

    private final static String VIEW_REGISTRATION = "registration";

    private IUserService userService;

    @Autowired
    RegistrationController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(GET_MAPPING_REGISTRATION)
    public ModelAndView showRegistrationPage() {
        return new ModelAndView(VIEW_REGISTRATION);
    }

    public void registerUser(UserFormModel userFormModel) {
        // save the user
        // transform userFormModel to UserEntity
    }

    public String redirectToHomePage() {
        // the user presses a button to go back to the home page
        return "redirect:/";
    }

    public String redirectToQuizPage() {
        // the user presses a button to go to the quiz page
        // they want to play with the newly created user
        return "redirect:/quiz";
    }

}

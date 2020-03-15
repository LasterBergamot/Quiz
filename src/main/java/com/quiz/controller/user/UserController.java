package com.quiz.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.quiz.service.IUserService;

@Controller
public class UserController {

    private static final String GET_MAPPING_USER = "/user";

    private static final String VIEW_USER = "user";

    private IUserService userService;

    @Autowired
    UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping(GET_MAPPING_USER)
    public ModelAndView showUserPage() {
        // dropdown list with all of the users

        // when one is selected, fill a form with its data

        return new ModelAndView(VIEW_USER);
    }

    public void saveModifiedUser() {
        // get the data from the form

        // save it to the database

        // reload the page (redirect maybe)
    }
}

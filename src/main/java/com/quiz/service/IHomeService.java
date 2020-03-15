package com.quiz.service;

import java.util.List;

import com.quiz.domain.user.User;

public interface IHomeService {

    void populateDatabase();

    List<User> findAllUsers();
}

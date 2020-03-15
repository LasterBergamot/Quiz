package com.quiz.service;

import java.util.List;
import java.util.UUID;

import com.quiz.domain.user.User;

public interface IUserService {

    void saveUser(User user);
    void deleteUserByUuid(UUID uuid);
    User findUserByUuid(UUID uuid);
    List<User> findAllUsers();
}

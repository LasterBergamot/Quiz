package com.quiz.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.user.User;
import com.quiz.repository.user.UserRepository;
import com.quiz.service.IUserService;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Autowired
    UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {

    }

    @Override
    public void deleteUserByUuid(UUID uuid) {

    }

    @Override
    public User findUserByUuid(UUID uuid) {
        return null;
    }

    @Override
    public List<User> findAllUsers() {
        return null;
    }
}

package com.quiz.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.domain.user.User;
import com.quiz.domain.user.transformer.UserTransformer;
import com.quiz.repository.entity.user.UserEntity;
import com.quiz.repository.user.UserRepository;
import com.quiz.service.IUserService;

@Service
public class UserService implements IUserService {

    private UserRepository userRepository;
    private UserTransformer userTransformer;

    @Autowired
    UserService(UserRepository userRepository, UserTransformer userTransformer) {
        this.userRepository = userRepository;
        this.userTransformer = userTransformer;
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(userTransformer.transformUserToUserEntity(user));
    }

    @Override
    public void deleteUserByUuid(UUID uuid) {
        userRepository.deleteById(uuid);
    }

    @Override
    public User findUserByUuid(UUID uuid) {
        Optional<UserEntity> optionalUserEntity = userRepository.findById(uuid);

        return optionalUserEntity.isPresent() ? userTransformer.transformUserEntityToUser(optionalUserEntity.get()) : new User();
    }

    @Override
    public List<User> findAllUsers() {
        List<UserEntity> userEntities = StreamSupport
                .stream(userRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        return userEntities.stream()
                .map(userEntity -> userTransformer.transformUserEntityToUser(userEntity))
                .collect(Collectors.toList());
    }
}

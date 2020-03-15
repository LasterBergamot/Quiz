package com.quiz.repository.user;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import com.quiz.repository.entity.user.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, UUID> {}

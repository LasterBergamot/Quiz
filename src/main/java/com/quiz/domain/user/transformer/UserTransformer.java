package com.quiz.domain.user.transformer;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quiz.domain.answer.transformer.AnswerTransformer;
import com.quiz.domain.user.User;
import com.quiz.repository.entity.user.UserEntity;

@Component
public class UserTransformer {

    private AnswerTransformer answerTransformer;

    public UserTransformer() {}

    @Autowired
    UserTransformer(AnswerTransformer answerTransformer) {
        this.answerTransformer = answerTransformer;
    }

    public UserEntity transformUserToUserEntity(User user) {
        return new UserEntity(user.getName(), user.getAge(), answerTransformer.transformAnswersToAnswerEntities(user.getAnswers()));
    }

    public User transformUserEntityToUser(UserEntity userEntity) {
        return new User(userEntity.getUuid(), userEntity.getName(), userEntity.getAge(), answerTransformer.transformAnswerEntitiesToAnswers(userEntity.getAnswerEntities()));
    }
}

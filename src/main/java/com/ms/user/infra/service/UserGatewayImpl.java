package com.ms.user.infra.service;

import com.ms.user.application.gateway.user.UserGateway;
import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;
import com.ms.user.infra.config.rabbitmq.producers.UserProducer;
import com.ms.user.infra.entity.UserEntity;
import com.ms.user.infra.mapper.user.UserMapper;
import com.ms.user.infra.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final UserProducer userProducer;

    public UserGatewayImpl(UserRepository userRepository, UserMapper userMapper, UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userProducer = userProducer;
    }

    @Override
    @Transactional
    public SaveUserOutput saveUser(SaveUserInput saveUserInput) {
        UserEntity userEntity = userMapper.toUserEntity(saveUserInput);
        userRepository.save(userEntity);
        userProducer.publishMessageEmail(userEntity);
        return new SaveUserOutput(userEntity.getUserId(), userEntity.getName(), userEntity.getEmail());
    }
}

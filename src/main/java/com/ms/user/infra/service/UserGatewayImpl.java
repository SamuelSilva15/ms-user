package com.ms.user.infra.service;

import com.ms.user.application.gateway.user.UserGateway;
import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;
import com.ms.user.infra.entity.UserEntity;
import com.ms.user.infra.mapper.user.UserMapper;
import com.ms.user.infra.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserGatewayImpl implements UserGateway {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserGatewayImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public SaveUserOutput saveUser(SaveUserInput saveUserInput) {
        UserEntity userEntity = userMapper.toUserEntity(saveUserInput);
        userRepository.save(userEntity);
        return new SaveUserOutput(userEntity.getUserId(), userEntity.getName(), userEntity.getEmail());
    }
}

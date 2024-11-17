package com.ms.user.infra.mapper.user;

import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.infra.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(SaveUserInput saveUserInput) {
        return new UserEntity(saveUserInput.name(), saveUserInput.email());
    }
}

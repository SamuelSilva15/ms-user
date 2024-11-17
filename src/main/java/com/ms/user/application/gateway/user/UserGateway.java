package com.ms.user.application.gateway.user;

import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;

public interface UserGateway {
    SaveUserOutput saveUser(SaveUserInput saveUserInput);
}

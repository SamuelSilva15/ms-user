package com.ms.user.application.usecaseimpl.user.save;

import com.ms.user.application.gateway.user.UserGateway;
import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;
import com.ms.user.usecase.user.save.SaveUserUsacase;

public class SaveUserUsecaseImpl implements SaveUserUsacase {

    private final UserGateway userGateway;

    public SaveUserUsecaseImpl(UserGateway userGateway) {
        this.userGateway = userGateway;
    }


    @Override
    public SaveUserOutput execute(SaveUserInput saveUserInput) {
        return userGateway.saveUser(saveUserInput);
    }
}

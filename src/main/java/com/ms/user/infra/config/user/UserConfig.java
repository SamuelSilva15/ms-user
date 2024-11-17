package com.ms.user.infra.config.user;

import com.ms.user.application.gateway.user.UserGateway;
import com.ms.user.application.usecaseimpl.user.save.SaveUserUsecaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ms.user.usecase.user.save.SaveUserUsacase;

@Configuration
public class UserConfig {

    @Bean
    public SaveUserUsacase saveUserUsacase(UserGateway userGateway) {
        return new SaveUserUsecaseImpl(userGateway);
    }
}

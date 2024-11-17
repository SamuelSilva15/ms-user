package com.ms.user.infra.config.rabbitmq.producers;

import com.ms.user.infra.entity.UserEntity;
import com.ms.user.core.domain.email.EnviarEmail;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserProducer {

    private final RabbitTemplate rabbitTemplate;

    public UserProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(UserEntity userEntity) {
        var emailDto = new EnviarEmail(
                userEntity.getUserId(),
                userEntity.getEmail(),
                "Cadastro com sucesso!",
                userEntity.getName() + ", seja bem-vindo!");
        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}

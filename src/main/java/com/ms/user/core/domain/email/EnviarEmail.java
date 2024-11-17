package com.ms.user.core.domain.email;

import java.util.UUID;

public record EnviarEmail(UUID userId, String emailTo, String subject, String text) { }

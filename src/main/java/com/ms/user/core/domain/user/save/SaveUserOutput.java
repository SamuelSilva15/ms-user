package com.ms.user.core.domain.user.save;

import java.util.UUID;

public record SaveUserOutput(UUID userID, String name, String email) { }

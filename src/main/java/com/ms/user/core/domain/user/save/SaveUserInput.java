package com.ms.user.core.domain.user.save;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SaveUserInput(@NotBlank String name, @NotBlank @Email String email) { }
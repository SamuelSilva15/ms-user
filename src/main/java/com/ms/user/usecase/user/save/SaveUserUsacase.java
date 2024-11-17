package com.ms.user.usecase.user.save;

import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;

public interface SaveUserUsacase {
    SaveUserOutput execute(SaveUserInput saveUserInput);
}

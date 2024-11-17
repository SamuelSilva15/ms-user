package com.ms.user.infra.controller.user;

import com.ms.user.core.domain.user.save.SaveUserInput;
import com.ms.user.core.domain.user.save.SaveUserOutput;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ms.user.usecase.user.save.SaveUserUsacase;

@RestController
public class UserController {

    private final SaveUserUsacase saveUserUsacase;

    public UserController(SaveUserUsacase saveUserUsacase) {
        this.saveUserUsacase = saveUserUsacase;
    }

    @PostMapping("/users")
    public ResponseEntity<SaveUserOutput> saveUser(@RequestBody @Valid SaveUserInput saveUserInput) {
        SaveUserOutput saveUserOutput = saveUserUsacase.execute(saveUserInput);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveUserOutput);
    }
}

package ru.itis.resume_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.resume_service.dto.TokenDto;
import ru.itis.resume_service.forms.SignInForm;
import ru.itis.resume_service.services.SignInService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/api/signIn")
@RequiredArgsConstructor
public class SignInController {

    private final SignInService signInService;

    @PostMapping
    public ResponseEntity<?> confirmLogin(@RequestBody SignInForm signInForm) {
        TokenDto token = signInService.signIn(signInForm);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            throw new IllegalArgumentException("Wrong data");
        }
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}

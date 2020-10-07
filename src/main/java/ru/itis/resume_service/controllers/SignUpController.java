package ru.itis.resume_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.itis.resume_service.forms.SignUpForm;
import ru.itis.resume_service.services.SignUpService;

@RestController
@PreAuthorize("permitAll()")
@RequestMapping("/api/signUp")
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping
    public ResponseEntity<?> signUp(@RequestBody SignUpForm signUpForm) {
        return ResponseEntity
                .ok()
                .body(signUpService.signUp(signUpForm));
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity
                .badRequest()
                .body(ex.getMessage());
    }
}

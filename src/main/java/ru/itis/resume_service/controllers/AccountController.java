package ru.itis.resume_service.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.itis.resume_service.forms.UserUpdateForm;
import ru.itis.resume_service.mappers.UsersMapper;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.security.details.UserDetailsImpl;
import ru.itis.resume_service.services.UsersService;

@RestController
@PreAuthorize("isAuthenticated()")
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final UsersService usersService;
    private final UsersMapper usersMapper;

    @GetMapping
    public ResponseEntity<?> getAccount(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        return ResponseEntity
                .ok()
                .body(usersMapper.userToUserDto(userDetails.getUser()));
    }

    @PutMapping
    public ResponseEntity<?> updateAccount(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                           @RequestBody UserUpdateForm form) {
        User user = usersService.updateUserAccount(userDetails.getUser(), form);
        userDetails.setUser(user);

        return ResponseEntity
                .ok()
                .body(user);
    }
}

package ru.itis.resume_service.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.resume_service.forms.SignUpForm;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.models.enums.Role;
import ru.itis.resume_service.repositories.UsersRepository;
import ru.itis.resume_service.services.SignUpService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder encoder;

    @Override
    public User signUp(SignUpForm form) {
        Optional<User> userCandidate = usersRepository.getByEmail(form.getEmail());
        if (userCandidate.isEmpty()) {
            User user = User.builder()
                    .email(form.getEmail())
                    .name(form.getName())
                    .surname(form.getSurname())
                    .phoneNumber(form.getPhoneNumber())
                    .settlement(form.getSettlement())
                    .age(form.getAge())
                    .password(encoder.encode(form.getPassword()))
                    .role(Role.USER)
                    .build();
            return usersRepository.save(user);
        } else {
            throw new IllegalArgumentException("User already exist");
        }
    }
}

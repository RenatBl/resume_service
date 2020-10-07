package ru.itis.resume_service.services.impl;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.itis.resume_service.dto.TokenDto;
import ru.itis.resume_service.forms.SignInForm;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.repositories.UsersRepository;
import ru.itis.resume_service.services.SignInService;

@Service
@RequiredArgsConstructor
public class SignInServiceImpl implements SignInService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public TokenDto signIn(SignInForm form) {
        User user = usersRepository.getByEmail(form.getEmail())
                .orElseThrow(() ->
                        new IllegalArgumentException("User with email " + form.getEmail() + " doesn't exist")
                );
        if (passwordEncoder.matches(form.getPassword(), user.getPassword())) {
            String token = Jwts.builder()
                    .setSubject(user.getId().toString())
                    .claim("name", user.getEmail())
                    .claim("role", user.getRole().name())
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
            return new TokenDto(token);
        } else throw new IllegalArgumentException("Wrong password");
    }
}
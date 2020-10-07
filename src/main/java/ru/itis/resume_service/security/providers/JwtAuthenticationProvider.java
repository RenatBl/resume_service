package ru.itis.resume_service.security.providers;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.repositories.UsersRepository;
import ru.itis.resume_service.security.authentication.JwtAuthentication;
import ru.itis.resume_service.security.details.UserDetailsImpl;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationProvider implements AuthenticationProvider {

    private final UsersRepository usersRepository;

    @Value("${jwt.secret}")
    private String secret;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String token = authentication.getName();
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            throw new AuthenticationCredentialsNotFoundException("Bad token");
        }
        String id = claims.get("sub", String.class);
        ObjectId objectId = new ObjectId(id);
        Optional<User> userCandidate = usersRepository.getById(objectId);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            authentication.setAuthenticated(true);
            ((JwtAuthentication) authentication).setUserDetails(UserDetailsImpl.builder()
                    .user(user)
                    .build());
        }
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return JwtAuthentication.class.equals(authentication);
    }
}
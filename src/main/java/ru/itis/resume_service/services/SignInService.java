package ru.itis.resume_service.services;

import ru.itis.resume_service.dto.TokenDto;
import ru.itis.resume_service.forms.SignInForm;

public interface SignInService {

    TokenDto signIn(SignInForm form);

}

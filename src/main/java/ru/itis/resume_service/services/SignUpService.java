package ru.itis.resume_service.services;

import ru.itis.resume_service.forms.SignUpForm;
import ru.itis.resume_service.models.User;

public interface SignUpService {

    User signUp(SignUpForm form);

}

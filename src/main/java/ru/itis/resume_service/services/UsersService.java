package ru.itis.resume_service.services;

import ru.itis.resume_service.forms.UserUpdateForm;
import ru.itis.resume_service.models.User;

public interface UsersService {

    User updateUserAccount(User user, UserUpdateForm form);

}

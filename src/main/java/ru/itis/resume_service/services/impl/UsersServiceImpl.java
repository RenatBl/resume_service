package ru.itis.resume_service.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.itis.resume_service.forms.UserUpdateForm;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.repositories.UsersRepository;
import ru.itis.resume_service.services.UsersService;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public User updateUserAccount(User user, UserUpdateForm form) {
        user.setEmail(form.getEmail());
        user.setName(form.getName());
        user.setSurname(form.getSurname());
        user.setAge(form.getAge());
        user.setSettlement(form.getSettlement());
        user.setPhoneNumber(form.getPhoneNumber());

        return usersRepository.save(user);
    }
}

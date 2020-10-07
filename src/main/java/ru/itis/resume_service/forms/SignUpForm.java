package ru.itis.resume_service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpForm {

    private String email;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    private String phoneNumber;
    private String settlement;
}

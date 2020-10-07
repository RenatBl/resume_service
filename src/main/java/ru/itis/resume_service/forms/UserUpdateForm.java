package ru.itis.resume_service.forms;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateForm {

    private ObjectId id;
    private String email;
    private String password;
    private String name;
    private String surname;
    private Integer age;
    private String phoneNumber;
    private String settlement;
}

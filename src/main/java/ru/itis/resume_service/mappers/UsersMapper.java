package ru.itis.resume_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.itis.resume_service.dto.UserDto;
import ru.itis.resume_service.models.User;
import ru.itis.resume_service.services.UsersService;

import java.util.Collection;
import java.util.List;

@Mapper
public interface UsersMapper {

    @Mappings({
            @Mapping(target="email", source="user.email"),
            @Mapping(target="name", source="user.name"),
            @Mapping(target="surname", source="user.surname"),
            @Mapping(target="age", source="user.age"),
            @Mapping(target="phoneNumber", source="user.phoneNumber"),
            @Mapping(target="settlement", source="user.settlement")
    })
    UserDto userToUserDto(User user);
}

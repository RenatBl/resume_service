package ru.itis.resume_service.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.resume_service.models.User;

import java.util.Optional;

public interface UsersRepository extends MongoRepository<User, Long> {
    Optional<User> getByEmail(String email);
    Optional<User> getById(ObjectId id);
}

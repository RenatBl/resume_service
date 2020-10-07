package ru.itis.resume_service.repositories;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import ru.itis.resume_service.models.Resume;

import java.util.List;

public interface ResumeRepository extends MongoRepository<Resume, ObjectId> {
    List<Resume> getByOwnerId(ObjectId objectId);
}

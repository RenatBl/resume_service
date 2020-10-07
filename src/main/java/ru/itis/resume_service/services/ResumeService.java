package ru.itis.resume_service.services;

import org.bson.types.ObjectId;
import ru.itis.resume_service.dto.ListResumeDto;
import ru.itis.resume_service.dto.ResumeDto;
import ru.itis.resume_service.forms.ResumeForm;
import ru.itis.resume_service.forms.ResumeUpdateForm;
import ru.itis.resume_service.models.Resume;
import ru.itis.resume_service.models.User;

import java.util.List;

public interface ResumeService {

    Resume createNewResume(ResumeForm form, User user);

    Resume updateResume(ResumeUpdateForm form);

    ResumeDto getResume(ObjectId id, User user);

    List<ListResumeDto> getResumeByUser(ObjectId userId);

    void deleteResume(ObjectId id);

}

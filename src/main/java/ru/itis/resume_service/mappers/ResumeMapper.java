package ru.itis.resume_service.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.itis.resume_service.dto.ListResumeDto;
import ru.itis.resume_service.dto.ResumeDto;
import ru.itis.resume_service.models.Resume;
import ru.itis.resume_service.models.User;

import java.util.Collection;
import java.util.List;

@Mapper
public interface ResumeMapper {

    @Mappings({
            @Mapping(target="id", source="resume.id"),
            @Mapping(target="name", source="user.name"),
            @Mapping(target="surname", source="user.surname"),
            @Mapping(target="age", source="user.age"),
            @Mapping(target="email", source="user.email"),
            @Mapping(target="phoneNumber", source="user.phoneNumber"),
            @Mapping(target="settlement", source="user.settlement"),
            @Mapping(target="jobTitle", source="resume.jobTitle"),
            @Mapping(target="workExperiences", source="resume.workExperiences"),
            @Mapping(target="employmentType", source="resume.employmentType"),
            @Mapping(target="skills", source="resume.skills"),
            @Mapping(target="educations", source="resume.educations"),
            @Mapping(target="languages", source="resume.languages"),
            @Mapping(target="dateOfCreating", source="resume.dateOfCreating")
    })
    ResumeDto resumeToDto(Resume resume, User user);

    @Mappings({
            @Mapping(target="id", source="resume.id"),
            @Mapping(target="jobTitle", source="resume.jobTitle"),
            @Mapping(target="dateOfCreating", source="resume.dateOfCreating")
    })
    List<ListResumeDto> resumeToDto(Collection<Resume> resumeCollection);

}

package ru.itis.resume_service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import ru.itis.resume_service.models.embedded.Education;
import ru.itis.resume_service.models.embedded.Language;
import ru.itis.resume_service.models.embedded.WorkExperience;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResumeDto {

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    private String name;
    private String surname;
    private Integer age;
    private String email;
    private String phoneNumber;
    private String settlement;
    private String jobTitle;
    private List<WorkExperience> workExperiences;
    private String employmentType;
    private List<String> skills;
    private List<Education> educations;
    private List<Language> languages;
    private String dateOfCreating;
}

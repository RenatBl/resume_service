package ru.itis.resume_service.forms;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
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
public class ResumeUpdateForm {

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    private String jobTitle;
    private List<WorkExperience> workExperiences;
    private String employmentType;
    private List<String> skills;
    private List<Education> educations;
    private List<Language> languages;
}

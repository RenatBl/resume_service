package ru.itis.resume_service.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import ru.itis.resume_service.models.embedded.Education;
import ru.itis.resume_service.models.embedded.Language;
import ru.itis.resume_service.models.embedded.WorkExperience;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "resume")
public class Resume {

    @Id
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    @Indexed
    private ObjectId ownerId;

    private String jobTitle;

    private List<WorkExperience> workExperiences;

    private String employmentType;

    private List<String> skills;

    private List<Education> educations;

    private List<Language> languages;

    private LocalDateTime dateOfCreating;
}

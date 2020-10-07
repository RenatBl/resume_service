package ru.itis.resume_service.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkExperience {

    private String workingPlace;
    private String position;
    private String workingTime;
}

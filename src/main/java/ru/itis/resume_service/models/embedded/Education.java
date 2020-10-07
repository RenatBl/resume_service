package ru.itis.resume_service.models.embedded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    private String level;
    private String graduationYear;
    private String institution;
    private String specialization;
}

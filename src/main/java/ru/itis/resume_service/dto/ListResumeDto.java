package ru.itis.resume_service.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ListResumeDto {

    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId id;

    private String jobTitle;
    private LocalDateTime dateOfCreating;
}

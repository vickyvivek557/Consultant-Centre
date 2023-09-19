package com.example.consult_center.dto.inputDTO;

import com.example.consult_center.Enum.JobRole;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorDetailsInput {
    String phoneNO;

    JobRole jobRole;

    String cv;
}

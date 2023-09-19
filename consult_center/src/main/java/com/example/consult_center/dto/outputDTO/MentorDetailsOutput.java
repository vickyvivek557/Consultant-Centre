package com.example.consult_center.dto.outputDTO;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.JobRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MentorDetailsOutput {
    String name;

    String email;

    int age;

    Gender gender;

    String phoneNO;

    JobRole jobRole;

    String cv;
}

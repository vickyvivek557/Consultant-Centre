package com.example.consult_center.dto.outputDTO;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.JobRole;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MentorOutput {
    int mentorId;

    String name;

    String email;

    int age;

    Gender gender;

    String phoneNo;

    JobRole jobRole;

    String cv;
}

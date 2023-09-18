package com.example.consult_center.dto.outputDTO;

import com.example.consult_center.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MentorRequestOutput {
    String name;

    String email;

    int age;

    Gender gender;

    String message;
}

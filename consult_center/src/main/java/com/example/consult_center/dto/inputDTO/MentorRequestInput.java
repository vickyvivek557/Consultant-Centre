package com.example.consult_center.dto.inputDTO;

import com.example.consult_center.Enum.Gender;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MentorRequestInput {
    String name;

    String email;

    int age;

    Gender gender;

}

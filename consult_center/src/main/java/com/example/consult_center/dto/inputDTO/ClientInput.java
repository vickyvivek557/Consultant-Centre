package com.example.consult_center.dto.inputDTO;

import com.example.consult_center.Enum.Gender;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ClientInput {
    String name;

    int age;

    Gender gender;

    String email;
}

package com.example.consult_center.model;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.JobRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mentorId;

    String name;

    String email;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String phoneNO;

    @Enumerated(EnumType.STRING)
    JobRole jobRole;

    String cv;
}

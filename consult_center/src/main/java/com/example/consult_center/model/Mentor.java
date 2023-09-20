package com.example.consult_center.model;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.JobRole;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "mentor_info")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int mentorId;

    String name;

    @Column(unique = true, nullable = false)
    String email;

    int age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    String phoneNO;

    @Enumerated(EnumType.STRING)
    JobRole jobRole;

    String cv;

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    List<ClientEntity> clients = new ArrayList<>();

    @OneToMany(mappedBy = "mentor", cascade = CascadeType.ALL)
    List<SessionEntity> sessions = new ArrayList<>();

}

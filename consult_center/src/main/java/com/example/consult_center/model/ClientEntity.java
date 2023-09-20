package com.example.consult_center.model;

import com.example.consult_center.Enum.Gender;
import com.example.consult_center.Enum.SessonStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "client_info")
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String name;

    int age;

    @Enumerated(value = EnumType.STRING)
    Gender gender;

    @Column(unique = true, nullable = false)
    String email;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "booking_status")
    SessonStatus status;

    @ManyToOne
    @JoinColumn(name = "mentor_id")
    Mentor mentor;

    @OneToOne(mappedBy = "client", cascade = CascadeType.ALL)
    SessionEntity session;
}

package com.example.consult_center.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int totalConsultants;

    int totalClients;

    int totalSessions;

}

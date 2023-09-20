package com.example.consult_center.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "booked_session_list")
public class SessionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String tockenNo; //UUID

    @CreationTimestamp
    Date bookingTime;

    @ManyToOne
    @JoinColumn(name = "mentor_id", nullable = false)
    Mentor mentor;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false)
    ClientEntity client;
}

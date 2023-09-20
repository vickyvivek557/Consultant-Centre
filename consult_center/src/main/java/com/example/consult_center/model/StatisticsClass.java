package com.example.consult_center.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StatisticsClass {

    int totalNoOfCunsultants;

    int totalNoOfClients;

    int totalNoofSessionsBooked;
}

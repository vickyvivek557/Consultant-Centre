package com.example.consult_center.dto.outputDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class SessionOutput {
    String tokentNO;

    Date bookingDate;

    String mentorName;

    String clientName;
}

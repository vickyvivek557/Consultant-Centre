package com.example.consult_center.transformer;

import com.example.consult_center.dto.outputDTO.SessionOutput;
import com.example.consult_center.model.SessionEntity;

public class SessionTransformer {
    public static SessionOutput SessionToSessionOutput(SessionEntity session){
        return SessionOutput.builder()
                .tokentNO(session.getTockenNo())
                .bookingDate(session.getBookingTime())
                .mentorName(session.getMentor().getName())
                .clientName(session.getClient().getName())
                .build();
    }
}

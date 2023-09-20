package com.example.consult_center.transformer;

import com.example.consult_center.Enum.SessonStatus;
import com.example.consult_center.dto.inputDTO.ClientInput;
import com.example.consult_center.dto.outputDTO.ClientOutput;
import com.example.consult_center.model.ClientEntity;

public class ClientTransformer {
    public static ClientEntity ClientInputToClient(ClientInput input){
        return ClientEntity.builder()
                .name(input.getName())
                .age(input.getAge())
                .gender(input.getGender())
                .email(input.getEmail())
                .status(SessonStatus.NOT_BOOKED)
                .build();
    }

    public static ClientOutput ClientToClientOutput(ClientEntity client){
        return ClientOutput.builder()
                .name(client.getName())
                .email(client.getEmail())
                .build();
    }
}

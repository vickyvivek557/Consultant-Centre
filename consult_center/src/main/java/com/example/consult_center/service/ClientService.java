package com.example.consult_center.service;

import com.example.consult_center.dto.inputDTO.ClientInput;
import com.example.consult_center.dto.outputDTO.ClientOutput;
import com.example.consult_center.dto.outputDTO.SessionOutput;

public interface ClientService {
    public ClientOutput registerClient(ClientInput clientInput);

    public SessionOutput bookSession(int mentorId, int clientId);

}

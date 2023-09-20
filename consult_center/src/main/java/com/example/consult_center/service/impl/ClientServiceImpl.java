package com.example.consult_center.service.impl;

import com.example.consult_center.Enum.SessonStatus;
import com.example.consult_center.dto.inputDTO.ClientInput;
import com.example.consult_center.dto.outputDTO.ClientOutput;
import com.example.consult_center.dto.outputDTO.SessionOutput;
import com.example.consult_center.exception.ClientNotFoundException;
import com.example.consult_center.exception.MentorNotFoundException;
import com.example.consult_center.exception.SessionAlreadyBookedException;
import com.example.consult_center.model.ClientEntity;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.SessionEntity;
import com.example.consult_center.repository.ClientRepository;
import com.example.consult_center.repository.MentorRepository;
import com.example.consult_center.repository.SessionRepository;
import com.example.consult_center.service.ClientService;
import com.example.consult_center.transformer.ClientTransformer;
import com.example.consult_center.transformer.SessionTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public ClientOutput registerClient(ClientInput clientInput) {
        //check whether client exists or not (by email id)
        ClientEntity client = clientRepository.findByEmail(clientInput.getEmail());

        if(client != null){
            return null;
        }
        //now create client from client Input
        ClientEntity newClient = ClientTransformer.ClientInputToClient(clientInput);

        //save the client
        ClientEntity savedClient = clientRepository.save(newClient);

        //create client output and return
        ClientOutput clientOutput = ClientTransformer.ClientToClientOutput(savedClient);
        clientOutput.setMessage("you have been registered successfully.");

        return clientOutput;
    }


    @Override
    public SessionOutput bookSession(int mentorId, int clientId) {
        //check whether mentor is present or not
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);

        if(optionalMentor.isEmpty()){
            throw new MentorNotFoundException("Invalid Mentor Id !!!");
        }

        //check whether client is present or not
        Optional<ClientEntity> optionalClient = clientRepository.findById(clientId);

        if(optionalClient.isEmpty()){
            throw new ClientNotFoundException("Invalid client Id !!!");
        }

        //check whether client's session status is booked or not
        ClientEntity client = optionalClient.get();
        if(client.getStatus() == SessonStatus.BOOKED){
            throw new SessionAlreadyBookedException("You have already a booked session.");
        }

        Mentor mentor = optionalMentor.get();

        //book session
        SessionEntity bookedSession = SessionEntity.builder()
                .client(client)
                .mentor(mentor)
                .tockenNo(UUID.randomUUID().toString())
                .build();

        //save the session
        sessionRepository.save(bookedSession);

        //add session in mentor and client entity, also mark session status as booked in client
        client.setStatus(SessonStatus.BOOKED);
        client.setMentor(mentor);

        mentor.getSessions().add(bookedSession);
        mentor.getClients().add(client);

        //save client and mentor, it will auto save the session (child class)
        clientRepository.save(client);
        mentorRepository.save(mentor);

        return SessionTransformer.SessionToSessionOutput(bookedSession);
    }
}

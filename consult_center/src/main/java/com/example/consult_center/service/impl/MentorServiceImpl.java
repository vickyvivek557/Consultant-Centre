package com.example.consult_center.service.impl;

import com.example.consult_center.dto.inputDTO.MentorDetailsInput;
import com.example.consult_center.dto.outputDTO.MentorOutput;
import com.example.consult_center.model.ClientEntity;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.SessionEntity;
import com.example.consult_center.model.StatisticsClass;
import com.example.consult_center.repository.ClientRepository;
import com.example.consult_center.repository.MentorRepository;
import com.example.consult_center.repository.SessionRepository;
import com.example.consult_center.service.MentorRequestService;
import com.example.consult_center.service.MentorService;
import com.example.consult_center.transformer.MentorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MentorServiceImpl implements MentorService {
    @Autowired
    MentorRepository mentorRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    SessionRepository sessionRepository;

    @Override
    public MentorOutput addDetailsOfMentor(int mentorId, MentorDetailsInput input) {
        //get mentor by id
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);

        if(optionalMentor.isEmpty()){
            return null;
        }
        Mentor mentor = optionalMentor.get();
        //add the mentor details
        mentor.setPhoneNO(input.getPhoneNO());
        mentor.setJobRole(input.getJobRole());
        mentor.setCv(input.getCv());

        //save the mentor
        Mentor savedMentor = mentorRepository.save(mentor);

        //convert saved mentor to mentor output and return

        return MentorTransformer.MentorToMentorOutput(savedMentor);
    }

    @Override
    public List<MentorOutput> getAllMentors() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<MentorOutput> mentorOutputs = new ArrayList<>();

        for(Mentor mentor : mentors){
            MentorOutput mentorOutput = MentorTransformer.MentorToMentorOutput(mentor);
            mentorOutputs.add(mentorOutput);
        }
        return mentorOutputs;
    }

    @Override
    public MentorOutput getMentorByEmail(String email) {
        Mentor mentor =  mentorRepository.getByEmail(email);

        if(mentor == null){
            return null;
        }
        return MentorTransformer.MentorToMentorOutput(mentor);
    }

    @Override
    public StatisticsClass getStatistics() {
        List<Mentor> mentors = mentorRepository.findAll();
        List<ClientEntity> clients = clientRepository.findAll();
        List<SessionEntity> sessions = sessionRepository.findAll();

        return StatisticsClass.builder()
                .totalNoOfClients(clients.size())
                .totalNoOfCunsultants(mentors.size())
                .totalNoofSessionsBooked(sessions.size())
                .build();
    }
}

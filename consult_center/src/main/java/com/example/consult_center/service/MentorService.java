package com.example.consult_center.service;

import com.example.consult_center.dto.inputDTO.MentorDetailsInput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.repository.MentorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    MentorRepository mentorRepository;

    public Mentor addDetailsOfMentor(int mentorId, MentorDetailsInput input) {
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

        return savedMentor;
    }
}

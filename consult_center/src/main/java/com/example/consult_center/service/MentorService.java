package com.example.consult_center.service;

import com.example.consult_center.dto.inputDTO.MentorDetailsInput;
import com.example.consult_center.dto.outputDTO.MentorOutput;
import com.example.consult_center.model.StatisticsClass;

import java.util.List;

public interface MentorService {

    public MentorOutput addDetailsOfMentor(int mentorId, MentorDetailsInput input);

    public List<MentorOutput> getAllMentors();

    public MentorOutput getMentorByEmail(String email);

    public StatisticsClass getStatistics();
}

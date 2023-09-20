package com.example.consult_center.service;

import com.example.consult_center.dto.inputDTO.MentorRequestInput;
import com.example.consult_center.dto.outputDTO.MentorRequestOutput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.MentorRequest;

import java.util.List;

public interface MentorRequestService {

    public MentorRequestOutput addMentorRequest(MentorRequestInput mentorRequestInput);

    public List<MentorRequest> getAllCunsultantReq();

    public MentorRequest rejectRequest(int requestId);

    public Mentor approveRequest(int id);
}

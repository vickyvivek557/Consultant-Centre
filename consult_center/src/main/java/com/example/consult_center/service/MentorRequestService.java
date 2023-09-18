package com.example.consult_center.service;

import com.example.consult_center.dto.inputDTO.MentorRequestInput;
import com.example.consult_center.dto.outputDTO.MentorRequestOutput;
import com.example.consult_center.model.MentorRequest;
import com.example.consult_center.repository.MentorRequestRepository;
import com.example.consult_center.transformer.MentorRequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentorRequestService {
    @Autowired
    MentorRequestRepository mentorRequestRepository;

    public MentorRequestOutput addMentorRequest(MentorRequestInput mentorRequestInput) {
        //convert mentor request input to mentor request entity
        MentorRequest mentorRequest = MentorRequestTransformer.MentorReqInpToMentorReq(mentorRequestInput);

        //save the mentor request
        MentorRequest savedRequest = mentorRequestRepository.save(mentorRequest);

        //convert saved mentorRequesst to mentorRequest output and return
        return MentorRequestTransformer.MentorReqToMentorReqOut(savedRequest);
    }
}

package com.example.consult_center.service.impl;

import com.example.consult_center.Enum.RequestStatus;
import com.example.consult_center.dto.inputDTO.MentorRequestInput;
import com.example.consult_center.dto.outputDTO.MentorRequestOutput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.MentorRequest;
import com.example.consult_center.repository.MentorRepository;
import com.example.consult_center.repository.MentorRequestRepository;
import com.example.consult_center.service.MentorRequestService;
import com.example.consult_center.transformer.MentorRequestTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MentorRequestServiceImpl implements MentorRequestService {
    @Autowired
    MentorRequestRepository mentorRequestRepository;

    @Autowired
    MentorRepository mentorRepository;

    @Override
    public MentorRequestOutput addMentorRequest(MentorRequestInput mentorRequestInput) {
        //check wether mentor request is already pressent or not(by email id)
        MentorRequest registeredRequest =
                mentorRequestRepository.findByEmail(mentorRequestInput.getEmail());

        if(registeredRequest != null){//means request exists already
            return null;
        }
        //convert mentor request input to mentor request entity
        MentorRequest mentorRequest = MentorRequestTransformer.MentorReqInpToMentorReq(mentorRequestInput);

        //set mentor request status to "APPLIED"
        mentorRequest.setRequestStatus(RequestStatus.APPLIED);

        //save the mentor request
        MentorRequest savedRequest = mentorRequestRepository.save(mentorRequest);

        //convert saved mentorRequesst to mentorRequest output and return
        return MentorRequestTransformer.MentorReqToMentorReqOut(savedRequest);
    }

    @Override
    public List<MentorRequest> getAllCunsultantReq() {
        return mentorRequestRepository.findByRequestStatus(RequestStatus.APPLIED);
    }

    @Override
    public MentorRequest rejectRequest(int requestId) {
        Optional<MentorRequest> optionalMentorRequest = mentorRequestRepository.findById(requestId);

        if(optionalMentorRequest.isEmpty()){
            return null;
        }
        //get mentor request and check the status of mentor request whether it is applied or not
        MentorRequest mentorRequest = optionalMentorRequest.get();

        //if mentor request status is not equal to applied it means already rejected or approved earlier
        if(mentorRequest.getRequestStatus() != RequestStatus.APPLIED){
            return null;
        }

        //set mentor request status to rejected and save it
        mentorRequest.setRequestStatus(RequestStatus.REJECTED);
        MentorRequest savedMentorReq = mentorRequestRepository.save(mentorRequest);

        return savedMentorReq;
    }

    @Override
    public Mentor approveRequest(int id) {
        Optional<MentorRequest> optionalMentorRequest = mentorRequestRepository.findById(id);

        if(optionalMentorRequest.isEmpty()){
            return null;
        }
        //get mentor request and check the status of mentor request whether it is applied or not
        MentorRequest mentorRequest = optionalMentorRequest.get();

        //if mentor request status is not equal to applied it means already rejected or approved earlier
        if(mentorRequest.getRequestStatus() != RequestStatus.APPLIED){
            return null;
        }

        //set mentor request status to approved and save it
        mentorRequest.setRequestStatus(RequestStatus.APPROVED);
        MentorRequest savedMentorReq = mentorRequestRepository.save(mentorRequest);

        //approved mentor request will be mentor now
        Mentor newMentor = MentorRequestTransformer.MentorReqToMentor(savedMentorReq);

        return mentorRepository.save(newMentor);
    }
}

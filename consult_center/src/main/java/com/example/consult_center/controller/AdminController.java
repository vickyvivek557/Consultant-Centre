package com.example.consult_center.controller;

import com.example.consult_center.dto.inputDTO.MentorDetailsInput;
import com.example.consult_center.dto.outputDTO.MentorOutput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.MentorRequest;
import com.example.consult_center.model.StatisticsClass;
import com.example.consult_center.service.impl.MentorRequestServiceImpl;
import com.example.consult_center.service.impl.MentorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MentorRequestServiceImpl mentorRequestServiceImpl;

    @Autowired
    MentorServiceImpl mentorServiceImpl;

    @GetMapping("/mentor_request/get_all")
    public ResponseEntity getAllCunsultantReq(){
        List<MentorRequest> mentorRequestList = mentorRequestServiceImpl.getAllCunsultantReq();
        if(mentorRequestList.size() <= 0){
            return new ResponseEntity("No cunsultant request found.", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(mentorRequestList, HttpStatus.FOUND);
    }

    @PutMapping("/reject_mentor_request/{id}")
    public ResponseEntity rejectRequest(@PathVariable("id") int requestId){
        MentorRequest response = mentorRequestServiceImpl.rejectRequest(requestId);
        if(response == null){
            return new ResponseEntity("Request id not found in applied list.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/approve_mentor_request/{id}")
    public ResponseEntity approveRequest(@PathVariable int id){
        Mentor response = mentorRequestServiceImpl.approveRequest(id);
        if(response == null){
            return new ResponseEntity("Request id not found in applied list.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_mentor_details/{id}")
    public ResponseEntity addDetailsOfMentor(@PathVariable("id") int mentorId,
                                             @RequestBody MentorDetailsInput input){

        MentorOutput response = mentorServiceImpl.addDetailsOfMentor(mentorId, input);
        if(response == null){
            return new ResponseEntity("Invalid Mentor id !!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }

    @GetMapping("get_all_mentors")
    public ResponseEntity getAllMentors(){
        List<MentorOutput> mentors = mentorServiceImpl.getAllMentors();
        if(mentors.size() <= 0){
            return new ResponseEntity("No any mentor foung.", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(mentors, HttpStatus.FOUND);
    }

    @GetMapping("/get_mentor_by_email/{email}")
    public ResponseEntity getMentorByEmail(@PathVariable String email){
        MentorOutput mentor = mentorServiceImpl.getMentorByEmail(email);
        if(mentor == null){
            return new ResponseEntity("Wrong Email Id.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(mentor, HttpStatus.FOUND);
    }

    @GetMapping("/get_statistics")
    public ResponseEntity getStatistics(){
        StatisticsClass statistics = mentorServiceImpl.getStatistics();
        return new ResponseEntity(statistics, HttpStatus.FOUND);
    }
}

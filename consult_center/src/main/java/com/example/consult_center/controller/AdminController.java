package com.example.consult_center.controller;

import com.example.consult_center.dto.inputDTO.MentorDetailsInput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.MentorRequest;
import com.example.consult_center.service.MentorRequestService;
import com.example.consult_center.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    MentorRequestService mentorRequestService;

    @Autowired
    MentorService mentorService;

    @GetMapping("/mentor_request/get_all")
    public ResponseEntity getAllCunsultantReq(){
        List<MentorRequest> mentorRequestList = mentorRequestService.getAllCunsultantReq();
        if(mentorRequestList.size() <= 0){
            return new ResponseEntity("No cunsultant request found.", HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(mentorRequestList, HttpStatus.FOUND);
    }

    @PutMapping("/reject_mentor_request/{id}")
    public ResponseEntity rejectRequest(@PathVariable("id") int requestId){
        MentorRequest response = mentorRequestService.rejectRequest(requestId);
        if(response == null){
            return new ResponseEntity("Request id not found in applied list.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PutMapping("/approve_mentor_request/{id}")
    public ResponseEntity approveRequest(@PathVariable int id){
        Mentor response = mentorRequestService.approveRequest(id);
        if(response == null){
            return new ResponseEntity("Request id not found in applied list.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.ACCEPTED);
    }

    @PostMapping("/add_mentor_details/{id}")
    public ResponseEntity addDetailsOfMentor(@PathVariable("id") int mentorId,
                                             @RequestBody MentorDetailsInput input){

        Mentor response = mentorService.addDetailsOfMentor(mentorId, input);
        if(response == null){
            return new ResponseEntity("Invalid Mentor id !!", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.OK);
    }
}

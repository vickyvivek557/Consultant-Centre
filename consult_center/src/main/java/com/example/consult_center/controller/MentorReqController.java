package com.example.consult_center.controller;

import com.example.consult_center.dto.inputDTO.MentorRequestInput;
import com.example.consult_center.dto.outputDTO.MentorRequestOutput;
import com.example.consult_center.service.impl.MentorRequestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mentor_request")
public class MentorReqController {
    @Autowired
    MentorRequestServiceImpl mentorRequestServiceImpl;

    @PostMapping("/add")
    public ResponseEntity addMentorRequest(@RequestBody MentorRequestInput mentorRequestInput){
        MentorRequestOutput response = mentorRequestServiceImpl.addMentorRequest(mentorRequestInput);
        if(response == null){
            return new ResponseEntity("your request Failed!! Request already exists.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
}

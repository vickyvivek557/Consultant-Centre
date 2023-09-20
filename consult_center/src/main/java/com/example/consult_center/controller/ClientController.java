package com.example.consult_center.controller;

import com.example.consult_center.dto.inputDTO.ClientInput;
import com.example.consult_center.dto.outputDTO.ClientOutput;
import com.example.consult_center.dto.outputDTO.SessionOutput;
import com.example.consult_center.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientServiceImpl clientServiceImpl;

    @PostMapping("/register")
    public ResponseEntity registerClient(@RequestBody ClientInput clientInput){
        ClientOutput response = clientServiceImpl.registerClient(clientInput);
        if(response == null){
            return new ResponseEntity("Email id already registered.", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @PostMapping("/book_session/mentor_id/{mentorId}/client_id/{clientId}")
    public ResponseEntity bookSession(@PathVariable int mentorId, @PathVariable int clientId){
        try {
            SessionOutput bookedSession = clientServiceImpl.bookSession(mentorId, clientId);
            return new ResponseEntity(bookedSession, HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}

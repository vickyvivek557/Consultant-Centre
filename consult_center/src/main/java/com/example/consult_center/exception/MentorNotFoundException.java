package com.example.consult_center.exception;

public class MentorNotFoundException extends RuntimeException{
    public MentorNotFoundException (String message){
        super(message);
    }
}

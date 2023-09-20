package com.example.consult_center.exception;

public class SessionAlreadyBookedException extends RuntimeException{
        public SessionAlreadyBookedException(String message){
            super(message);
        }
}
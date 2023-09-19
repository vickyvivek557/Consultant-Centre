package com.example.consult_center.transformer;

import com.example.consult_center.dto.inputDTO.MentorRequestInput;
import com.example.consult_center.dto.outputDTO.MentorRequestOutput;
import com.example.consult_center.model.Mentor;
import com.example.consult_center.model.MentorRequest;

public class MentorRequestTransformer {
    public static MentorRequest MentorReqInpToMentorReq(MentorRequestInput mentorRequestInput){
        return MentorRequest.builder()
                .name(mentorRequestInput.getName())
                .email(mentorRequestInput.getEmail())
                .age(mentorRequestInput.getAge())
                .gender(mentorRequestInput.getGender())
                .build();
    }

    public static MentorRequestOutput MentorReqToMentorReqOut(MentorRequest mentorRequest){
        return MentorRequestOutput.builder()
                .name(mentorRequest.getName())
                .email(mentorRequest.getEmail())
                .age(mentorRequest.getAge())
                .gender(mentorRequest.getGender())
                .message("Your request submitted successfully.")
                .build();
    }

    public static Mentor MentorReqToMentor(MentorRequest mentorRequest){
        return Mentor.builder()
                .name(mentorRequest.getName())
                .email(mentorRequest.getEmail())
                .age(mentorRequest.getAge())
                .gender(mentorRequest.getGender())
                .build();
    }
}

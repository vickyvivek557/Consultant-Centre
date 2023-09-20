package com.example.consult_center.transformer;


import com.example.consult_center.dto.outputDTO.MentorOutput;
import com.example.consult_center.model.Mentor;

public class MentorTransformer {
    public static MentorOutput MentorToMentorOutput(Mentor mentor){
        return MentorOutput.builder()
                .mentorId(mentor.getMentorId())
                .name(mentor.getName())
                .age(mentor.getAge())
                .email(mentor.getEmail())
                .gender(mentor.getGender())
                .phoneNo(mentor.getPhoneNO())
                .jobRole(mentor.getJobRole())
                .cv(mentor.getCv())
                .build();
    }
}

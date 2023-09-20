package com.example.consult_center.repository;

import com.example.consult_center.Enum.RequestStatus;
import com.example.consult_center.model.MentorRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MentorRequestRepository extends JpaRepository<MentorRequest, Integer> {

    List<MentorRequest> findByRequestStatus(RequestStatus status);

    MentorRequest findByEmail(String email);

}

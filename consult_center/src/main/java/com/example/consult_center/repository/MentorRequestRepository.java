package com.example.consult_center.repository;

import com.example.consult_center.Enum.RequestStatus;
import com.example.consult_center.model.MentorRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MentorRequestRepository extends JpaRepository<MentorRequest, Integer> {

    List<MentorRequest> findByRequestStatus(RequestStatus status);

}

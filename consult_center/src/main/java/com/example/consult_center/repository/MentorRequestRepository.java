package com.example.consult_center.repository;

import com.example.consult_center.model.MentorRequest;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MentorRequestRepository extends JpaRepository<MentorRequest, Integer> {
}

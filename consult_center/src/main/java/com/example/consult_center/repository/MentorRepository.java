package com.example.consult_center.repository;

import com.example.consult_center.model.Mentor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Integer> {
    Mentor getByName(String name);

    Mentor getByEmail(String email);
}

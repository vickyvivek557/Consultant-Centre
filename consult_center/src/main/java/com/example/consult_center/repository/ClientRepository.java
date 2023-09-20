package com.example.consult_center.repository;

import com.example.consult_center.model.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Integer> {
    ClientEntity findByEmail(String email);
}

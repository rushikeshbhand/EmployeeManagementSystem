package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.Leave;

@Repository
public interface LeaveRepository extends JpaRepository<Leave, Long> {
    
}

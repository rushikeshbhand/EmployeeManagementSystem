package com.projectems.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projectems.entities.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    
}



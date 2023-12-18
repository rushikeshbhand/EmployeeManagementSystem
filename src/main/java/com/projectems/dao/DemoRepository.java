package com.projectems.dao;



import org.springframework.data.jpa.repository.JpaRepository;

import com.projectems.entities.Demo;



public interface DemoRepository extends JpaRepository<Demo, Integer>{

	Demo findByDemoUsernameAndDemoPassword(String demoUsername, String demoPassword);
}


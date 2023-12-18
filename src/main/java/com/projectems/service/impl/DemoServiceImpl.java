package com.projectems.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectems.dao.DemoRepository;
import com.projectems.entities.Demo;
import com.projectems.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService{

	@Autowired
	private DemoRepository demoRepository;
	
	@Override
	public Demo login(String demoUsername, String demoPassword) {
		Demo demo=demoRepository.findByDemoUsernameAndDemoPassword(demoUsername, demoPassword);
		return demo;
	}
}

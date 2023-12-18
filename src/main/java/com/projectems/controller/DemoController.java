package com.projectems.controller;


import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectems.entities.Demo;
import com.projectems.service.DemoService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@RequestMapping("/demo")
public class DemoController {

	
	@Autowired
	private DemoService demoService;
	
	@PostMapping("/login")
	public String validate(@RequestBody Demo demo) throws ServletException
	{
		String jwtToken="";
		
		if(demo.getDemoUsername()==null || demo.getDemoPassword()==null)
		{
			throw new ServletException("Please Fill in Demoname and Password");
		}
		
		String userName=demo.getDemoUsername();
		String password=demo.getDemoPassword();
		//will check in database whether the login and password is present or not
		demo=demoService.login(userName, password);
		
		if(demo==null)
		{
			throw new ServletException("DemoUser not found");
		}
		
		jwtToken=Jwts.builder().setSubject(userName).claim("demoName", demo.getDemoUsername()).
			setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "secretkey").compact();
		
		return jwtToken;
		
		
	}
}

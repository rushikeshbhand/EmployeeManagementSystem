package com.projectems.exceptions;

@SuppressWarnings("serial")
public class EmployeeNotFoundException extends Exception 
{
	public EmployeeNotFoundException(String message) 
	{
		super(message);
	}

}

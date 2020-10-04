package com.tcs.exception;

import javax.ws.rs.WebApplicationException;

public class EmployeeManagementException extends WebApplicationException {

	private String message;
	private static final long serialVersionUID = 2008371690031542675L;

	public EmployeeManagementException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}

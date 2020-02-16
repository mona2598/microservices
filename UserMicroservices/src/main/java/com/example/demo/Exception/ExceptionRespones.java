package com.example.demo.Exception;

import java.util.Date;

public class ExceptionRespones 
{
	private Date timestamp;
	private String message;
	private String details;
	public ExceptionRespones() {
		// TODO Auto-generated constructor stub
	}
	public ExceptionRespones(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public String getMessage() {
		return message;
	}
	public String getDetails() {
		return details;
	}


}

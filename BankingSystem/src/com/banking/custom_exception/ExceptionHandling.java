package com.banking.custom_exception;

@SuppressWarnings("serial")
public class ExceptionHandling extends Exception{
	public ExceptionHandling(String errMssg) {
		super(errMssg);
	}
}

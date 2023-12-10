package com.pv.exception;

public class AmountInvalidException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public AmountInvalidException() {

	}
	 
	 public AmountInvalidException(String msg) {
		 
		 super(msg);
		}
}

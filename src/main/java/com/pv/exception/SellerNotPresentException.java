package com.pv.exception;

public class SellerNotPresentException extends RuntimeException
{
	
	private static final long serialVersionUID = 1L;

	public SellerNotPresentException()
	{}
	
	public SellerNotPresentException(String msg)
	{
		super(msg);
	}
	
}

package com.pv.exception;

public class CategoryNotPresentException extends RuntimeException
{
   
	private static final long serialVersionUID = 1L;

	public CategoryNotPresentException()
   {}
   
   public CategoryNotPresentException(String msg)
   {
	   super(msg);
   }
}

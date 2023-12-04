package com.pv.exception;

public class ProductNotPresentException extends RuntimeException
{	
   
	private static final long serialVersionUID = 1L;

   public ProductNotPresentException() {}
   
   public ProductNotPresentException(String msg) {
	   super(msg);
   }
}

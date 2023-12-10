package com.pv.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pv.exception.ProductNotPresentException;
import com.pv.exception.AmountInvalidException;
import com.pv.exception.CategoryNotPresentException;
import com.pv.exception.SellerNotPresentException;

@ControllerAdvice
public class ExceptionController 
{
   @ExceptionHandler(value = AmountInvalidException.class)
   public ResponseEntity<Object> amountInvalidException(Exception e)
   {
	   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
   }
   
   @ExceptionHandler(value = ProductNotPresentException.class)
   public ResponseEntity<Object> productNotPresentException(Exception e)
   {
	   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = CategoryNotPresentException.class)
   public ResponseEntity<Object> categoryNotPresentException(Exception e)
   {
	   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
   }
   
   @ExceptionHandler(value = SellerNotPresentException.class)
   public ResponseEntity<Object> sellerNotPresentException(Exception e)
   {
	   return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
   }
   
}

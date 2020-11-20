package com.product.exception;

public class ErrorResponse  extends RuntimeException {
	
	public ErrorResponse(String exception) {
	        super(exception);
	    }
}

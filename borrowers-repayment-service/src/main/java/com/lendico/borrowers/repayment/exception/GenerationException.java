package com.lendico.borrowers.repayment.exception;

public class GenerationException extends RuntimeException{
	
	public GenerationException(String str) {
		super(str);
	}
	
	public GenerationException(String str, Throwable throwable) {
		super(str, throwable);
	}

}

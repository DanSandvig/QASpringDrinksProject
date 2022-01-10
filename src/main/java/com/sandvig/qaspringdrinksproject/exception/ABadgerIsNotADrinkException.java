package com.sandvig.qaspringdrinksproject.exception;

@SuppressWarnings("serial")
public class ABadgerIsNotADrinkException extends RuntimeException {
	
	public ABadgerIsNotADrinkException (String message) {
		super(message);
	}

	public ABadgerIsNotADrinkException() {
		
	}
}

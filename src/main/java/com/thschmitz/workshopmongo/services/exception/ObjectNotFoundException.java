package com.thschmitz.workshopmongo.services.exception;

public class ObjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	
	public ObjectNotFoundException(String msg) {
		super(msg); // Passei para a RuntimeException a mensagem que eu queria
	}
}

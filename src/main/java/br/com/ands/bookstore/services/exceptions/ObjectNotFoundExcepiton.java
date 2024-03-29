package br.com.ands.bookstore.services.exceptions;

import org.hibernate.ObjectNotFoundException;

/**
 * Classe para prover exceções para {@link ObjectNotFoundException}.
 * 
 * @author Adriano Neto Da Silva
 * @Date 13 de out. de 2023
 * @Project bookstore
 */
public class ObjectNotFoundExcepiton extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundExcepiton(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectNotFoundExcepiton(String message) {
		super(message);
	}
	
}

package br.com.ands.bookstore.services.exceptions;

/**
 * Classe para prover exceções para {@link org.springframework.dao.DataIntegrityViolationException}
 * 
 * @author Adriano Neto Da Silva
 * @Date 21 de out. de 2023
 * @Project bookstore
 */
public class DataIntegrityViolationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DataIntegrityViolationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataIntegrityViolationException(String message) {
		super(message);
	}
	
}

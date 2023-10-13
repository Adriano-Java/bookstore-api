package br.com.ands.bookstore.resources.exceptions;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ands.bookstore.services.exceptions.ObjectNotFoundExcepiton;
/**
 * Classe responsável pela manipulação das exceções.
 * 
 * @author Adriano Neto Da Silva
 * @Date 13 de out. de 2023
 * @Project bookstore
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	@ExceptionHandler(ObjectNotFoundExcepiton.class)
	public ResponseEntity<StandardError> objetctNotFoundException(ObjectNotFoundExcepiton e, ServletRequest request){
		StandardError error = new StandardError(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}

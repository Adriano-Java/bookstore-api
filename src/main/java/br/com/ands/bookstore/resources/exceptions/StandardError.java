package br.com.ands.bookstore.resources.exceptions;

/**
 * Classe que instancia as mensagens personalizadas
 * para as exceções.
 * 
 * @author Adriano Neto Da Silva
 * @Date 13 de out. de 2023
 * @Project bookstore
 */
public class StandardError {
	private Long timestamp;
	private Integer status;
	private String error;
	
	public StandardError() {
		super();
	}

	public StandardError(Long timestamp, Integer status, String error) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}

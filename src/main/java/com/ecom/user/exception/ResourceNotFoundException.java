package com.ecom.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a requested resource is not found. Maps to HTTP 404 Not
 * Found status for REST clients.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new ResourceNotFoundException with a message.
	 *
	 * @param message description of the missing resource
	 */
	public ResourceNotFoundException(String message) {
		super(message);
	}

	/**
	 * Creates a new ResourceNotFoundException with a message and a cause.
	 *
	 * @param message description of the missing resource
	 * @param cause   underlying cause of the exception
	 */
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}

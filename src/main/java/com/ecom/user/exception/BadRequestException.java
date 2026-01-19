package com.ecom.user.exception;

/**
 * Exception thrown when client input is invalid or violates business rules.
 * Represents HTTP 400: Bad Request in REST APIs.
 */
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructs new BadRequestException with a descriptive message.
	 *
	 * @param message human-readable message explaining the bad request
	 */
	public BadRequestException(String message) {
		super(message);
	}

	/**
	 * Constructs new BadRequestException with a descriptive message and the
	 * underlying cause.
	 *
	 * @param message human-readable message explaining the bad request
	 * @param cause   underlying exception
	 */
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}

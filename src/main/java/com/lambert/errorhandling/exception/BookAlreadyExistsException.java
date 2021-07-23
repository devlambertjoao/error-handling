package com.lambert.errorhandling.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "Book already exists")
public class BookAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * @throws When a book already exists
	 */
	public BookAlreadyExistsException() {
		super();
	}
}

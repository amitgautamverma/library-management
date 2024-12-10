package com.rbccm.library.exception;

public class BookAlreadyExistsException extends RuntimeException {

	private String message;

	public BookAlreadyExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
}

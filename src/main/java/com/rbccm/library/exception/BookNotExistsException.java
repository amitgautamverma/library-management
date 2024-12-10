package com.rbccm.library.exception;

public class BookNotExistsException extends RuntimeException {

	private String message;

	public BookNotExistsException(String msg) {
		super(msg);
		this.message = msg;
	}
}

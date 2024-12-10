package com.rbccm.library.exception;

public class BookInvalidDataException extends RuntimeException {

	private String message;

	public BookInvalidDataException(String msg) {
		super(msg);
		this.message = msg;
	}
}

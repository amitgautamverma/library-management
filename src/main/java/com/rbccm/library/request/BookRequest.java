package com.rbccm.library.request;

public class BookRequest {

	private long bookeId;

	private String bookTitle;

	private String bookAuthor;

	private double bookPrice;

	public long getBookeId() {
		return bookeId;
	}

	public void setBookeId(long bookeId) {
		this.bookeId = bookeId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	@Override
	public String toString() {
		return "BookRequest [bookeId=" + bookeId + ", bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor
				+ ", bookPrice=" + bookPrice + "]";
	}

	public BookRequest(long bookeId, String bookTitle, String bookAuthor, double bookPrice) {
		super();
		this.bookeId = bookeId;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookPrice = bookPrice;
	}

}

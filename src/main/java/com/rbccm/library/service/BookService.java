package com.rbccm.library.service;

import java.util.List;

import com.rbccm.library.Entity.Book;
import com.rbccm.library.reponse.BookResponse;
import com.rbccm.library.request.BookRequest;

public interface BookService {

	public Book addBook(BookRequest book);

	public String updateBook(BookRequest bookRequest,long id);

	public List<BookResponse> getBooks();

	public BookResponse getBook(long id);

	public String deleteBook(long id);
}

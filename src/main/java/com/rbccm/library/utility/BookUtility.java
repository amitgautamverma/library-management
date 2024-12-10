package com.rbccm.library.utility;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.rbccm.library.Entity.Book;
import com.rbccm.library.exception.BookInvalidDataException;
import com.rbccm.library.repository.BookRepository;
import com.rbccm.library.request.BookRequest;

public class BookUtility {

	public static void validateBookDetails(BookRequest book) {

		if (book.getBookTitle().isBlank() || book.getBookTitle().isEmpty()) {

			throw new BookInvalidDataException("Book title is null or empty.");

		} else if (book.getBookAuthor().isBlank() || book.getBookAuthor().isEmpty()) {

			throw new BookInvalidDataException("Book author is null or empty.");

		} else if (book.getBookeId() <= 0) {

			throw new BookInvalidDataException("Book id is invalid.");

		} else if (book.getBookPrice() <= 0) {

			throw new BookInvalidDataException("Book price is invalid.");

		}

	}
}

package com.rbccm.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rbccm.library.Entity.Book;
import com.rbccm.library.exception.BookAlreadyExistsException;
import com.rbccm.library.exception.BookInvalidDataException;
import com.rbccm.library.exception.BookNotExistsException;
import com.rbccm.library.reponse.BookResponse;
import com.rbccm.library.repository.BookRepository;
import com.rbccm.library.request.BookRequest;
import com.rbccm.library.utility.BookUtility;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepo;

	@Override
	public Book addBook(BookRequest bookRequest) {

		BookUtility.validateBookDetails(bookRequest);
		Optional<Book> bookDetails = bookRepo.findById(bookRequest.getBookeId());
		if (!bookDetails.isEmpty()) {

			throw new BookAlreadyExistsException("Book already exist with this id");
		}
		Book book = new Book(bookRequest.getBookeId(), bookRequest.getBookTitle(), bookRequest.getBookAuthor(),
				bookRequest.getBookPrice());

		return bookRepo.save(book);

	}

	@Override
	public String updateBook(BookRequest bookRequest, long id) {

		BookUtility.validateBookDetails(bookRequest);
		Optional<Book> bookDetails = bookRepo.findById(id);

		if (!bookDetails.isEmpty()) {
			Book book = new Book(bookRequest.getBookeId(), bookRequest.getBookTitle(), bookRequest.getBookAuthor(),
					bookRequest.getBookPrice());

			bookRepo.save(book);
		} else {
			throw new BookNotExistsException("books not found.");

		}

		return "Book details updated sucessfully.";

	}

	@Override
	public List<BookResponse> getBooks() {

		List<Book> books = bookRepo.findAll();
		if (books.size() > 0) {
			List<BookResponse> bookList = new ArrayList<>();
			for (Book book : books) {

				BookResponse bookResponse = new BookResponse(book.getId(), book.getTitle(), book.getAuthor(),
						book.getPrice());
				bookList.add(bookResponse);
			}
			return bookList;

		} else {

			throw new BookNotExistsException("books not found.");
		}
	}

	@Override
	public BookResponse getBook(long id) {

		Optional<Book> book = bookRepo.findById(id);
		if (!book.isEmpty()) {

			BookResponse bookResponse = new BookResponse(book.get().getId(), book.get().getTitle(),
					book.get().getAuthor(), book.get().getPrice());
			return bookResponse;
		}

		else {

			throw new BookNotExistsException("book not found.");
		}
	}

	@Override
	public String deleteBook(long id) {
		if (id > 0) {
			Optional<Book> book = bookRepo.findById(id);
			if (!book.isEmpty()) {
				bookRepo.deleteById(id);
				return "Book details deleted sucessfully";

			} else {
				throw new BookNotExistsException("book not found with given id");
			}
		} else {
			throw new BookInvalidDataException("book id is invalid.");
		}
	}
}

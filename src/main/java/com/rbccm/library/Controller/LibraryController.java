package com.rbccm.library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rbccm.library.Entity.Book;
import com.rbccm.library.reponse.BookResponse;
import com.rbccm.library.request.BookRequest;
import com.rbccm.library.service.BookService;

@RestController
@RequestMapping("/books")
public class LibraryController {

	@Autowired
	private BookService bookService;

	@PostMapping("/")
	public ResponseEntity<Book> addBook(@RequestBody BookRequest bookRequest) {

		return ResponseEntity.status(HttpStatus.CREATED).body(bookService.addBook(bookRequest));

	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateBook(@RequestBody BookRequest bookRequest, @PathVariable("id") long id) {

		return ResponseEntity.status(HttpStatus.OK).body(bookService.updateBook(bookRequest, id));
	}

	@GetMapping()
	public ResponseEntity<List<BookResponse>> getBooks() {

		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBooks());
	}

	@GetMapping("/{id}")
	public ResponseEntity<BookResponse> getBook(@PathVariable("id") long id) {

		return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable("id") long id) {

		return ResponseEntity.status(HttpStatus.OK).body(bookService.deleteBook(id));
	}
}

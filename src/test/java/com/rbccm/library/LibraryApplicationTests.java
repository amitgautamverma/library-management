package com.rbccm.library;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.rbccm.library.Controller.LibraryController;
import com.rbccm.library.Entity.Book;
import com.rbccm.library.reponse.BookResponse;
import com.rbccm.library.request.BookRequest;
import com.rbccm.library.service.BookService;

@SpringBootTest
class LibraryApplicationTests {

	@InjectMocks
	private LibraryController library;

	@Mock
	BookService bookService;

	@Test
	public void addBookTest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

		Book book = new Book(11, "demo", "demo", 200);
		BookRequest bookRequest = new BookRequest(11, "demo", "demo", 200);

		when(bookService.addBook(bookRequest)).thenReturn(book);
		ResponseEntity<Book> response = library.addBook(bookRequest);

		assertThat(response.getStatusCode().is2xxSuccessful());
		assertThat(response.getBody().getId()).isEqualTo(11);
	}

	@Test
	public void getBookTest() {
		BookResponse book = new BookResponse(1, "demo", "amit", 200);

		when(bookService.getBook(1L)).thenReturn(book);

		ResponseEntity<BookResponse> result = library.getBook(1l);

		assertThat(result.getBody().getBookeId()).isEqualTo(1L);
		assertThat(result.getBody().getBookTitle()).isEqualTo(book.getBookTitle());
	}
}

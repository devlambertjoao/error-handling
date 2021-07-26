package com.lambert.errorhandling.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.lambert.errorhandling.exception.BookNotFoundException;
import com.lambert.errorhandling.service.BookService;

@AutoConfigureMockMvc
public class BookControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(BookControllerTest.class);

	private MockMvc mockMvc;

	@Mock
	private BookService bookService;

	@InjectMocks
	private BookController bookController;

	@BeforeAll
	static void beforeAll() {
		logger.info("Tests started!");
	}

	@AfterAll
	static void afterAll() {
		logger.info("Tests ended!");
	}

	@BeforeEach
	void beforeEach() {
		MockitoAnnotations.openMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(bookController).build();
	}

	@Test
	@DisplayName("GET /books must return No Content when list is empty")
	public void findAllMustReturnNoContentWhenListIsEmpty() throws Exception {
		Mockito.when(bookService.findAll()).thenThrow(BookNotFoundException.class);
		mockMvc.perform(MockMvcRequestBuilders.get("/books")).andExpect(MockMvcResultMatchers.status().isNoContent());
	}

	@Test
	@DisplayName("GET /books must return OK when exist at least one book")
	@Disabled
	public void findAllMustReturnOkWhenFindBooks() {
	}

	@Test
	@DisplayName("GET /books/{name} must return No Content when not found a book")
	@Disabled
	public void findByIdMustReturnNoContentWhenNotFound() {
	}

	@Test
	@DisplayName("GET /books/{name} must return OK when book exist")
	@Disabled
	public void findByIdMustReturnOkWhenBookExists() {
	}

	@Test
	@DisplayName("POST /books")
	@Disabled
	public void createBookWithValidContentMustSucess() {
	}

	@Test
	@DisplayName("POST /books with duplicated name")
	@Disabled
	public void createBookWithDuplicatedNameMustReturnUnprocessableEntity() {
	}
}

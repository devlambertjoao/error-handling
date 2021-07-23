package com.lambert.errorhandling.controller;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BookControllerTest {

	private static final Logger logger = LoggerFactory.getLogger(BookControllerTest.class);
	
	@BeforeAll
	static void beforeAll() {
		logger.info("Tests started!");
	}

	@AfterAll
	static void afterAll() {
		logger.info("Tests ended!");
	}
	
	@Test
	@DisplayName("/books must return No Content when list is empty")
	@Disabled
	public void findAllMustReturnNoContentWhenListIsEmpty() {
	}
}

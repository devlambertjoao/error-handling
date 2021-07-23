package com.lambert.errorhandling.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lambert.errorhandling.dto.BookDTO;
import com.lambert.errorhandling.exception.BookAlreadyExistsException;
import com.lambert.errorhandling.exception.BookNotFoundException;
import com.lambert.errorhandling.service.BookService;

@RestController
@RequestMapping(value = "/books")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findAll() throws BookNotFoundException {
		return new ResponseEntity<>(bookService.findAll(), HttpStatus.OK);
	}

	@GetMapping(path = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> findByName(@PathVariable("name") String name) throws BookNotFoundException {
		return new ResponseEntity<>(bookService.findByName(name), HttpStatus.OK);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> save(@RequestBody BookDTO bookDTO) throws BookAlreadyExistsException {
		bookService.save(bookDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}

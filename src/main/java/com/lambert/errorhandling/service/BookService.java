package com.lambert.errorhandling.service;

import java.util.List;

import com.lambert.errorhandling.dto.BookDTO;
import com.lambert.errorhandling.exception.BookAlreadyExistsException;
import com.lambert.errorhandling.exception.BookNotFoundException;

public interface BookService {

	List<BookDTO> findAll() throws BookNotFoundException;
	BookDTO findByName(String name) throws BookNotFoundException;
	void save(BookDTO bookDTO) throws BookAlreadyExistsException;
}

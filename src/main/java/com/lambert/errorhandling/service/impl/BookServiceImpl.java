package com.lambert.errorhandling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lambert.errorhandling.dto.BookDTO;
import com.lambert.errorhandling.exception.BookAlreadyExistsException;
import com.lambert.errorhandling.exception.BookNotFoundException;
import com.lambert.errorhandling.repository.BookRepository;
import com.lambert.errorhandling.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<BookDTO> findAll() throws BookNotFoundException {
		return bookRepository.findAll();
	}

	@Override
	public BookDTO findByName(String name) throws BookNotFoundException {
		return bookRepository.findByName(name);
	}

	@Override
	public void save(BookDTO bookDTO) throws BookAlreadyExistsException {
		bookRepository.save(bookDTO);
	}

}

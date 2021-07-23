package com.lambert.errorhandling.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lambert.errorhandling.dto.BookDTO;
import com.lambert.errorhandling.exception.BookAlreadyExistsException;
import com.lambert.errorhandling.exception.BookNotFoundException;
import com.lambert.errorhandling.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	private List<BookDTO> bookList = new ArrayList<>();

	@Override
	public List<BookDTO> findAll() throws BookNotFoundException {
		throwIfBookListIsEmpty();
		return bookList;
	}

	private void throwIfBookListIsEmpty() throws BookNotFoundException {
		if (bookList.isEmpty()) {
			throw new BookNotFoundException();
		}
	}

	@Override
	public BookDTO findByName(String name) throws BookNotFoundException {
		BookDTO book = findBookByNameOrReturnNull(name);
		throwIfBookIsNull(book);
		return book;
	}

	private void throwIfBookIsNull(BookDTO bookDTO) throws BookNotFoundException {
		if (bookDTO == null) {
			throw new BookNotFoundException();
		}
	}

	@Override
	public void save(BookDTO bookDTO) throws BookAlreadyExistsException {
		if (findBookByNameOrReturnNull(bookDTO.getName()) == null) {
			bookList.add(bookDTO);
			return;
		}

		throw new BookAlreadyExistsException();
	}

	private BookDTO findBookByNameOrReturnNull(String name) {
		return bookList.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
	}

}

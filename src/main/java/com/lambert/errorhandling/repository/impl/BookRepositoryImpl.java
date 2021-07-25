package com.lambert.errorhandling.repository.impl;

import java.util.List;
import java.util.ArrayList;

import com.lambert.errorhandling.dto.BookDTO;
import com.lambert.errorhandling.exception.BookAlreadyExistsException;
import com.lambert.errorhandling.exception.BookNotFoundException;
import com.lambert.errorhandling.repository.BookRepository;

import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {

	private List<BookDTO> bookList = new ArrayList<>();

	@Override
	public List<BookDTO> findAll() throws BookNotFoundException {
		throwIfBookListIsEmpty();
		return bookList;
	}

	@Override
	public BookDTO findByName(String name) throws BookNotFoundException {
		BookDTO book = findBookByNameOrReturnNull(name);
		throwIfBookIsNull(book);
		return book;
	}

	@Override
	public void save(BookDTO bookDTO) throws BookAlreadyExistsException {
		if (findBookByNameOrReturnNull(bookDTO.getName()) == null) {
			bookList.add(bookDTO);
			return;
		}

		throw new BookAlreadyExistsException();	
	}

	private void throwIfBookListIsEmpty() throws BookNotFoundException {
		if (bookList.isEmpty()) {
			throw new BookNotFoundException();
		}
	}

	private void throwIfBookIsNull(BookDTO bookDTO) throws BookNotFoundException {
		if (bookDTO == null) {
			throw new BookNotFoundException();
		}
	}

	private BookDTO findBookByNameOrReturnNull(String name) {
		return bookList.stream().filter(b -> b.getName().equals(name)).findFirst().orElse(null);
	}

}

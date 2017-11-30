package edu.sdp.com.manager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sdp.com.entities.Book;
import edu.sdp.com.manager.mapper.ManagerBookMapper;
import edu.sdp.com.manager.service.ManagerBookService;

@Service
public class ManagerBookServiceImpl implements ManagerBookService {
	@Autowired
	private ManagerBookMapper managerBookMapper;

	@Override
	public List<Book> getBooks() {

		return managerBookMapper.getBooks();
	}

	@Override
	public void addBook(Book book) {
		managerBookMapper.addBook(book);

	}

	@Override
	public Book getBookById(Integer id) {
		Book book = managerBookMapper.getBookById(id);
		return book;
	}

	@Override
	public void update(Book book) {
		managerBookMapper.update(book);
	}

	@Override
	public void deleteBookById(Integer id) {
		managerBookMapper.deleteBookById(id);
	}

}

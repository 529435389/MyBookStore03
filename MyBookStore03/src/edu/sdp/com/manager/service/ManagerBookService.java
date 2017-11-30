package edu.sdp.com.manager.service;

import java.util.List;

import edu.sdp.com.entities.Book;

public interface ManagerBookService {
	public abstract List<Book> getBooks();

	public abstract void addBook(Book book);

	public abstract Book getBookById(Integer id);

	public abstract void update(Book book);

	public abstract void deleteBookById(Integer id);
}

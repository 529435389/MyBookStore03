package edu.sdp.com.manager.mapper;

import java.util.ArrayList;

import edu.sdp.com.entities.Book;

public interface ManagerBookMapper {
	public abstract ArrayList<Book> getBooks();

	public abstract void addBook(Book book);

	public abstract Book getBookById(Integer id);

	public abstract void update(Book book);

	public abstract void deleteBookById(Integer id);
}

package edu.sdp.com.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sdp.com.client.mapper.BookMapper;
import edu.sdp.com.client.service.BookService;
import edu.sdp.com.entities.Book;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	private BookMapper bookMapper;

	@Override
	public List<Book> getBooks() {
		return bookMapper.getBooks();
	}

}

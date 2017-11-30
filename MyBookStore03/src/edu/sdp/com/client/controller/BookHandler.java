package edu.sdp.com.client.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.sdp.com.client.service.BookService;
import edu.sdp.com.entities.Book;

@RequestMapping("/client")
@Controller
public class BookHandler {
	@Autowired
	private BookService bookService;

	@RequestMapping("/getBooks")
	public String getBooks(@RequestParam(value = "pageNo", required = false) Integer pageNo, Map<String, Object> map) {
		Integer defaultPageNo = 1;
		try {
			defaultPageNo = pageNo;
		} catch (Exception e) {
			System.out.println("getBooks方法中空指针异常");
		}
		Page<Book> page = PageHelper.startPage(defaultPageNo, 4);
		List<Book> books = bookService.getBooks();
		PageInfo<Book> pageInfo = new PageInfo<>(books, 5);
		books.forEach(System.out::println);
		map.put("list", books);
		map.put("pageInfo", pageInfo);
		return "client/index";
	}
}

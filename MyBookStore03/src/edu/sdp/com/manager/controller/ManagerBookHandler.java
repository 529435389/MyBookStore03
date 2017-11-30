package edu.sdp.com.manager.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import edu.sdp.com.entities.Book;
import edu.sdp.com.manager.service.ManagerBookService;

@RequestMapping("/managerBook")
@Controller
public class ManagerBookHandler {
	@Autowired
	private ManagerBookService managerBookService;

	@RequestMapping("/getBooks")
	public String getBooks(@RequestParam("pageNo") Integer pageNo, Map<String, Object> map) {
		Integer defaultPageNo = 1;
		try {
			defaultPageNo = pageNo;
		} catch (Exception e) {
			System.out.println("managerBookHandler方法出现异常");
		}
		Page<Book> page = PageHelper.startPage(defaultPageNo, 5);
		List<Book> books = managerBookService.getBooks();
		PageInfo<Book> pageInfo = new PageInfo<>(books, 5);
		map.put("page", books);
		map.put("pageInfo", pageInfo);
		return "manager/book_manager";
	}

	@RequestMapping("/addBook")
	public String addBook(Book book) {
		managerBookService.addBook(book);
		return "redirect:/managerBook/getBooks?pageNo=1";
	}

	@RequestMapping("/updateBook")
	public String updateBook(@RequestParam("id") Integer id, Map<String, Object> map) {
		Book book = managerBookService.getBookById(id);
		map.put("book", book);
		return "manager/book_edit";
	}

	@RequestMapping("/editBook")
	public String editBook(Book book) {
		managerBookService.update(book);
		return "redirect:/managerBook/getBooks?pageNo=1";
	}

	@RequestMapping("/deleteBook")
	public String deleteBook(@RequestParam("id") Integer id) {
		managerBookService.deleteBookById(id);
		return "redirect:/managerBook/getBooks?pageNo=1";
	}
}

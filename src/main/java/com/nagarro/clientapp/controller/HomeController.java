package com.nagarro.clientapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nagarro.clientapp.pojo.Book;
import com.nagarro.clientapp.service.HomeService;

@Controller
@RequestMapping(path = "/home")
public class HomeController {

	public final HomeService homeService;

	@Autowired
	public HomeController(HomeService homeService) {
		this.homeService = new HomeService();
	}

	@GetMapping
	public String home(HttpSession session)
			throws IOException, ParseException, org.json.simple.parser.ParseException, java.text.ParseException {

		String user = (String) session.getAttribute("username");
		if (user == null) {
			return "login";
		}
		
		List<Book> booksdata = homeService.getBooksdata();

		session.setAttribute("booksdata", booksdata);
		return "home";
	}

	@RequestMapping(value = "/addbook", method = RequestMethod.POST)
	public String addbook(@ModelAttribute("book") Book book) throws IOException {
		Book existingBook = this.homeService.getBookByBookCode(book.getBookcode());

		if (existingBook != null) {
			return "redirect:/home/";
		}
		homeService.addbook(book);
		return "redirect:/home/";
	}

	@RequestMapping("/editform")
	public String showEditForm() {

		return "edit";
	}
	
	@RequestMapping("/edit/{id}")
	public String handleEditForm(@PathVariable("id") long bookId, HttpSession session) {
		Book book = this.homeService.getBookById(bookId);
		session.setAttribute("book", book);
		
		return "redirect:/home/editform";

	}

	@RequestMapping("/delete/{id}")
	public String deletebook(@PathVariable("id") long bookid , HttpServletRequest request)
			throws IOException, org.json.simple.parser.ParseException, java.text.ParseException {
		
		homeService.deletebook(bookid);
		
		return "redirect:/home/";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateBook(@ModelAttribute("book") Book book) {
		
		this.homeService.updateBook(book);
		return "redirect:/home/";

	}

	@PostMapping("/logout")
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("username");
		session.invalidate();

		return "redirect:/";
	}

}

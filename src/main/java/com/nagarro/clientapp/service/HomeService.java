package com.nagarro.clientapp.service;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nagarro.clientapp.pojo.Book;

@Service
public class HomeService {

	private RestTemplate restTemplate = new RestTemplate();
	private String url = "http://localhost:8080/api/books/";
	
	public List<Book> getBooksdata(){
		ResponseEntity<List<Book>> responseEntity = 
				  restTemplate.exchange(
				    url,
				    HttpMethod.GET,
				    null,
				    new ParameterizedTypeReference<List<Book>>() {}
				  );
				List<Book> books = responseEntity.getBody();
				return books;
	}

	public Book getBookById(long bookId) {
		Book book = this.restTemplate.getForObject(url + bookId, Book.class);
		return book;
	}
	
	public Book getBookByBookCode(long bookCode) {
		Book book = this.restTemplate.getForObject(url +"book/"+ bookCode, Book.class);
		return book;
	}
	
	public void addbook( Book book) throws IOException {
		this.restTemplate.postForEntity(url, book, Book.class);
	}

	public void deletebook(Long bookId) throws IOException {
		this.restTemplate.delete(url + bookId, Book.class);
	}

	public void updateBook(Book book) {
		this.restTemplate.put(url + book.getId(), book, Book.class);
		
	}

}

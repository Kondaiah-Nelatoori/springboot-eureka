package com.springboot.eureka.client.book.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.springboot.eureka.client.book.service.model.Book;
import com.springboot.eureka.client.book.service.repository.BookRepository;

@RestController
@RequestMapping("/book-service")
public class BookController {

	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private BookRepository bookRepository;
	
	@PostMapping("/addBooks")
	public List<Book> addBooks(@RequestBody List<Book> books){
		return bookRepository.saveAll(books);
		
	}
	
	@PostMapping("/addBook")
	public String addBook(Book book) {
		bookRepository.save(book);
		return "Added book with "+book.getId();
	}
	
	@GetMapping("/getBooks")
	public List<Book> getBooks(){
		return bookRepository.findAll();
	}
	
	@GetMapping("/invokePaymentService/{id}")
	public String invokePaymentService(@PathVariable("id") int id ) {
		String url = "http://PAYMENT-SERVICE/payment-service/paymentStatus/"+id;
		return restTemplate.getForObject(url, String.class);
		
	}
}

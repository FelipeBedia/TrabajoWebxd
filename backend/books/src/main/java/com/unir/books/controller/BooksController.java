package com.unir.books.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.unir.books.model.pojo.Book;
import com.unir.books.service.BooksService;
import com.unir.books.model.request.CreateBookRequest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@RestController
@RequiredArgsConstructor
@Slf4j
public class BooksController {
	
	private final BooksService service;
	
		 @GetMapping("/books")
		 public ResponseEntity<List<Book>> getProducts(@RequestHeader Map<String, String> headers) {
			 log.info("headers: {}", headers);
			 List<Book> products = service.getBooks();
			 if (products != null) {
			 return ResponseEntity.ok(products);
			 } else {
			 return ResponseEntity.ok(Collections.emptyList());
			 }
		 }
	
		 @GetMapping("/books/{bookId}")
		 public ResponseEntity<Book> getBooks(@PathVariable String bookId) {
			 log.info("Request received for book{}", bookId);
			 Book book = service.getBook(bookId);
			 if (book != null) {
				 return ResponseEntity.ok(book);
				 } else {
				 return ResponseEntity.notFound().build();
				 }
		}
		 
		 @DeleteMapping("/books/{bookId}")
		 public ResponseEntity<Void> deleteBooks(@PathVariable String bookId) {
			 Boolean removed = service.removeBook(bookId);
			 if (Boolean.TRUE.equals(removed)) {
			 return ResponseEntity.ok().build();
			 } else {
			 return ResponseEntity.notFound().build();
			 }
		 }
		 
		 @PostMapping("/books")
		 
		 public ResponseEntity<Book> getProduct(@RequestBody CreateBookRequest request) {
				  Book createdBook = service.createBook(request);
				  if (createdBook !=null) {
				  return 
				 ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
				  } else {
				  return ResponseEntity.badRequest ().build();
				  }
		}
}
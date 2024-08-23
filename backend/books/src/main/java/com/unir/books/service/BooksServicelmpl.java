package com.unir.books.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.unir.books.model.pojo.Book;


import com.unir.books.data.BookRepository;
import com.unir.books.model.request.CreateBookRequest;

@Service
public class BooksServicelmpl implements BooksService {
	 @Autowired
	 private BookRepository repository;
	 
	 @Override
	 public List<Book> getBooks() {
		 List<Book> books = repository.findAll();
		 return books.isEmpty() ? null : books;
	 }
	 
	 @Override
	 public Book getBook(String bookId) {
		 return repository.findById(Long.valueOf(bookId)).orElse(null);
	 }
	 
	 @Override
	 public Boolean removeBook(String bookId) {
		 Book book = repository.findById(Long.valueOf(bookId)).orElse(null);
		 if (book != null) {
			 repository.delete(book);
			 return Boolean.TRUE;
		 } else {
			 return Boolean.FALSE;
		 }
	}
		 
	 @Override
	 public Book createBook(CreateBookRequest request) {
	 if (request != null && StringUtils.hasLength(request.getTitulo().trim()) 
			 && StringUtils.hasLength(request.getAutor().trim())
			 && StringUtils.hasLength(request.getAno_publicacion().trim()) 
			 && StringUtils.hasLength(request.getIsbn10().trim())
			 && StringUtils.hasLength(request.getIsbn13().trim())
			 && StringUtils.hasLength(request.getImagen_portada().trim())
			 && StringUtils.hasLength(request.getSinopsis().trim()) 
			 && request.getVisible () != null) {
		 Book book = 
			 Book.builder().titulo(request.getTitulo()).autor(request.getAutor()).
			 ano_publicacion(request.getAno_publicacion()).isbn10(request.getIsbn10()).
			 isbn13(request.getIsbn13()).imagen_portada(request.getImagen_portada()).
			 sinopsis(request.getSinopsis()).visible(request.getVisible()).build();
			  return repository.save(book);
			  } else {
			  return null;
			  }
		}
}
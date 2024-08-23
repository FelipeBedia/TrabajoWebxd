package com.unir.books.service;
import com.unir.books.model.pojo.Book;
import com.unir.books.model.request.CreateBookRequest;

import java.util.List;

public interface BooksService{
 List<Book> getBooks();
 Book getBook(String bookId);
 Boolean removeBook(String bookId);
 Book createBook(CreateBookRequest request);
}

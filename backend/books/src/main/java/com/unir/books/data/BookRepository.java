package com.unir.books.data;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.unir.books.model.pojo.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
 List<Book> findByTitulo(String titulo);
}

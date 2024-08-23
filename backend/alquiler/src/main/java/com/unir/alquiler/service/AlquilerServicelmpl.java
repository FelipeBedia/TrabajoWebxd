package com.unir.alquiler.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.unir.alquiler.facade.BooksFacade;
import com.unir.alquiler.model.pojo.Book;
import com.unir.alquiler.model.request.AlquilerRequest;

@Service
public class AlquilerServicelmpl implements AlquilerService {
    
    @Autowired
    private BooksFacade booksFacade;

    @Override
    public String createAlquiler(AlquilerRequest request){
        List<Book> books= request.getBooks().stream().map(booksFacade::getBook).filter(Objects::nonNull).collect(Collectors.toList());
        return books.size() == request.getBooks().size() ? "OK" : "KO";
    }
}

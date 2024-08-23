package com.unir.alquiler.facade;

import com.unir.alquiler.model.pojo.Book;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
@Slf4j
public class BooksFacade {
    
    @Value("${getBook.url}")
    private String getBookUrl;

    private final RestTemplate restTemplate;

    public Book getBook(String id){
        try{
            return restTemplate.getForObject(String.format(getBookUrl, id), Book.class);
        }catch(HttpClientErrorException e){
            log.error("Client Error: [{}, Book with id {}", e.getStatusCode(), id);
        }
        return null;
    }

}

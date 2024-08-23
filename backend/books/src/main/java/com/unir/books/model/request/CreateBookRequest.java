package com.unir.books.model.request;


import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {
	
	private String titulo;
	private String autor;
	private String ano_publicacion;
	private String isbn10;
	private String isbn13;
	private String imagen_portada;
	private String sinopsis;
	private Boolean visible;
	
}


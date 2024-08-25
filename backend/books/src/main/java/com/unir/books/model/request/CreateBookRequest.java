package com.unir.books.model.request;


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
	private String anioPublicacion;
	private String isbn10;
	private String isbn13;
	private String criticas;
	private String imagenPortada;
	private String sinopsis;
	private Boolean visible;
	
}


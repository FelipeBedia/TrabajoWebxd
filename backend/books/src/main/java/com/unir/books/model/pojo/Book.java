package com.unir.books.model.pojo;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long id;
	 @Column(name = "titulo", unique = true)
	 private String titulo;
	 @Column(name = "autor")
	 private String autor;
	 @Column(name = "ano_publicacion")
	 private String ano_publicacion;
	 @Column(name = "isbn10")
	 private String isbn10;
	 @Column(name = "isbn13")
	 private String isbn13;
	 @Column(name = "imagen_portada")
	 private String imagen_portada;
	 @Column(name = "sinopsis")
	 private String sinopsis;
	 @Column(name = "visible")
	 private Boolean visible;
	 
	@Override
	public String toString() {
		return "Book [titulo=" + titulo + "]";
	}	
	 
	 
}

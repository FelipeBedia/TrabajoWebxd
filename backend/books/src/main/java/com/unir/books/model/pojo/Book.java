package com.unir.books.model.pojo;



import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "det_books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Book {
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 private Long cve_id;
	 @Column(name = "nom_titulo", unique = true)
	 private String titulo;
	 @Column(name = "nom_autor")
	 private String autor;
	 @Column(name = "num_anio_publicacion")
	 private String anioPublicacion;
	 @Column(name = "des_sinopsis")
	 private String sinopsis;
	 @Column(name = "cve_isbn10", unique = true)
	 private String isbn10;
	 @Column(name = "cve_isbn13", unique = true)
	 private String isbn13;
	 @Column(name = "des_criticas")
	 private String criticas;
	 @Column(name = "dat_imagen_portada")
	 private String imagenPortada;
	 @Column(name = "visible")
	 private Boolean visible;
	 
	@Override
	public String toString() {
		return "Book [titulo=" + titulo + "]";
	}	
	 
	 
}

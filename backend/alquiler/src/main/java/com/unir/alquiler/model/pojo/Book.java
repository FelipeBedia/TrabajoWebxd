package com.unir.alquiler.model.pojo;



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
	 @Column(name = "description")
	 private String description;
	 @Column(name = "visible")
	 private Boolean visible;
	 
	@Override
	public String toString() {
		return "Book [titulo=" + titulo + "]";
	}	
	 
	 
}

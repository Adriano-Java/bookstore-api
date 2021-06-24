package br.com.ands.bookstore;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.ands.bookstore.domain.Categoria;
import br.com.ands.bookstore.domain.Livro;
import br.com.ands.bookstore.repositories.CategoriaRepository;
import br.com.ands.bookstore.repositories.LivroRepository;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	
	@Autowired//injeta o repository
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//adiciona uma categoria
		Categoria c1 = new Categoria(null, "Informática", "Livros sobre TI");
		//adiciona um livro, já relacionando-o a uma categoria
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin", "blá, blá, blá", c1);
		//adiciona à categoria os livros
		c1.getLivros().addAll(Arrays.asList(livro1));
		//persistência dos dados
		this.categoriaRepository.saveAll(Arrays.asList(c1));
		this.livroRepository.saveAll(Arrays.asList(livro1));
	}

}

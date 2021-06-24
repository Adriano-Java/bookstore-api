package br.com.ands.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ands.bookstore.domain.Categoria;
import br.com.ands.bookstore.domain.Livro;
import br.com.ands.bookstore.repositories.CategoriaRepository;
import br.com.ands.bookstore.repositories.LivroRepository;

/**
 * 
 * @author Adriano Neto Da Silva
 * @date 24 de jun. de 2021
 * @project bookstore
 */
@Service
public class DBService {
	
	@Autowired//injeta o repository
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		// adiciona uma categoria
		Categoria c1 = new Categoria(null, "Informática", "Livros sobre TI");
		Categoria c2 = new Categoria(null, "Ficção Científica", "Ficção científica, SI-FI e space-opera");
		Categoria c3 = new Categoria(null, "Romances", "Romances e novelas");
		Categoria c4 = new Categoria(null, "Terror", "Horror e suspense");
		// adiciona um livro, já relacionando-o a uma categoria
		Livro livro1 = new Livro(null, "Clean Code", "Robert Martin",
				"Estruturação de código de forma lógica e objetiva", c1);
		Livro livro2 = new Livro(null, "Jornada nas Estrelas: O Retorno do Capitão Kirk", "Isabella Boskov",
				"A tripulação da nave USS Suzaku, comandada pela capitã Fei Lin, se depara com um novo planeta em formação. Lá, encontram uma colônia Borg e uma pessoa que não deveria mais estar entre nós...",
				c2);
		Livro livro3 = new Livro(null, "O Conde do Castelo Negro", "J.J. Star",
				"Um centenário vampiro reencontra o amor após salvar uma jovem de ser devorada por lobisomens.", c3);
		Livro livro4 = new Livro(null, "Java Moderno", "Pedro Augusto",
				"As mais recentes tendências do uso do Java, com dicas e boas práticas atuais", c1);
		Livro livro5 = new Livro(null, "Garoto de Programa", "Adriano Neto",
				"Os jovens devem começar cedo a programar, e este livro te ensina como orientá-los nesse sentido!", c1);
		Livro livro6 = new Livro(null, "O Chamado de Cthulhu", "H.P> Lovecraft",
				"Um terror antigo e abissal está prestes a despertar!", c4);
		Livro livro7 = new Livro(null, "Lázaro: O Impiedoso", "Adriano Neto",
				"A incrível história de um fugitivo da polícia que não mede esforços para escapar e espalhar o terror!",
				c4);
		Livro livro8 = new Livro(null, "O Despertar de Darth Addler!", "J.J. Abrams",
				"Numa galáxia distante, um novo sith surge e tenta conquistar todos os planetas da Liga Centauro", c2);
		Livro livro9 = new Livro(null, "Amor, Sexo e Cerveja", "Patrícia Montes Altos",
				"Uma mulher de 21 anos, fracassada na vida, resolve se tornar uma atriz porno caseira e passa a convidar estranhos de todos os tipos para transar com ela enquanto 'streama' o ato, tudo regado com muita cerveja",
				c3);
		// adiciona à categoria os livros
		c1.getLivros().addAll(Arrays.asList(livro1, livro4, livro5));
		c2.getLivros().addAll(Arrays.asList(livro2, livro8));
		c3.getLivros().addAll(Arrays.asList(livro3, livro9));
		c4.getLivros().addAll(Arrays.asList(livro6, livro7));
		// persistência dos dados
		this.categoriaRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
		this.livroRepository
				.saveAll(Arrays.asList(livro1, livro2, livro3, livro4, livro5, livro6, livro7, livro8, livro9));
	}

}

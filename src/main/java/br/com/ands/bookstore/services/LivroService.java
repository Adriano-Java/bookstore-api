package br.com.ands.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ands.bookstore.domain.Livro;
import br.com.ands.bookstore.repositories.LivroRepository;
import br.com.ands.bookstore.services.exceptions.ObjectNotFoundExcepiton;

/**
 *Classe pertecente à camada de serviço, responsável por conter as regras de
 *de negócio para {@link Livro}.
 * 
 * @author Adriano Neto Da Silva
 * @Date 21 de out. de 2023
 * @Project bookstore
 */
@Service
public class LivroService {
	@Autowired
	private LivroRepository repository;
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> livro = repository.findById(id);
		return livro.orElseThrow(() -> new ObjectNotFoundExcepiton(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Livro.class.getName()));
	}

	/**
	 * Metódo que retorna uma lista de objetos do tipo {@link Livro}
	 * por seu @param id_cat.
	 * 
	 * @param id_cat
	 * @return
	 */
	public List<Livro> findAllByCategoria(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategoriaIdOrderByTitulo(id_cat);
	}
}

package br.com.ands.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ands.bookstore.domain.Categoria;
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

	/**
	 * Método que atualiza os dados de um {@link Livro}.
	 * 
	 * @param id
	 * @param atualizacao
	 * @return
	 */
	public Livro update(Integer id, Livro livro) {
		Livro livroAtualizado = findById(id);
		updateData(livroAtualizado, livro);
		return repository.save(livroAtualizado);
	}

	private void updateData(Livro livroAtualizado, Livro livro) {
		if(livro != null) {
			if(livro.getTitulo() != null) {
				livroAtualizado.setTitulo(livro.getTitulo());
			}
			if(livro.getNomeDoAutor() != null) {
				livroAtualizado.setNomeDoAutor(livro.getNomeDoAutor());
			}
			if(livro.getTexto() != null) {
				livroAtualizado.setTexto(livro.getTexto());
			}
		}
	}

	/**
	 * Método que persiste um novo {@link Livro} na base de dados,
	 * associando-o a uma {@link Categoria}.
	 * 
	 * @param id_cat
	 * @param livro
	 * @return
	 */
	public Livro create(Integer id_cat, Livro livro) {
		livro.setId(null);
		Categoria categoria = categoriaService.findById(id_cat);
		livro.setCategoria(categoria);
		return repository.save(livro);
	}

	/**
	 * Método que exclui um {@link Livro} da base de dados.
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		Livro livro = findById(id);
		repository.delete(livro);
	}
}

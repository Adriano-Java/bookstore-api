package br.com.ands.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ands.bookstore.domain.Categoria;
import br.com.ands.bookstore.dtos.CategoriaDTO;
import br.com.ands.bookstore.repositories.CategoriaRepository;
import br.com.ands.bookstore.services.exceptions.ObjectNotFoundExcepiton;

/**
 * Classe pertecente à camada de serviço, responsável por conter as regras de
 * negócio para {@Categoria}.
 * 
 * @author Adriano Neto Da Silva
 * @date 12 de out. de 2023
 * @project bookstore-api
 */
@Service
public class CategoriaService {
	@Autowired
	private CategoriaRepository repository;

	/**
	 * Método da camada de serviço que recupera da base de dados uma
	 * {@Categoria} por seu ID.
	 * 
	 * @param id
	 * @return
	 */
	public Categoria findById(Integer id) {
		Optional<Categoria> objeto = repository.findById(id);
		return objeto.orElseThrow(() -> new ObjectNotFoundExcepiton(
				"Objeto não encontrado! ID: " + id + ", Tipo: " + Categoria.class.getName()));
	}
	
	/**
	 * Recupera uma lista de {@Categoria}, contendo todas
	 * as categorias persistidas na base de dados.
	 * 
	 * @return
	 */
	public List<Categoria> findAll() {
		return repository.findAll();
	}
	
	/**
	 * Método para persistir uma {@Categoria} na base de dados.
	 * 
	 * @param cat
	 * @return
	 */
	public Categoria create(Categoria cat) {
		cat.setId(null);
		return repository.save(cat);
	}

	/**
	 * Método para alterar e persistir uma {@Categoria} existente.
	 * 
	 * @param id
	 * @param dto
	 * @return
	 */
	public Categoria update(Integer id, CategoriaDTO dto) {
		Categoria categoria = findById(id);
		categoria.setNome(dto.getNome());
		categoria.setDescricao(dto.getDescricao());
		return repository.save(categoria);
	}
}

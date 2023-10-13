package br.com.ands.bookstore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ands.bookstore.domain.Categoria;
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
}

package br.com.ands.bookstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ands.bookstore.domain.Categoria;
import br.com.ands.bookstore.services.CategoriaService;

/**
 * Classe do tipo RestController responsável pelo gerenciamento
 * das categorias de livros via end-points.
 * 
 * A categoria de um livro é representada pela entidade {@Categoria}.
 * 
 * @author Adriano Neto Da Silva
 * @date 12 de out. de 2023
 * @project bookstore-api
 */
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
	@Autowired
	private CategoriaService service;
	
	/**
	 * Método que recupera uma {@Categoria} através de um
	 * @param id passado por @PathVariable.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		Categoria categoria = service.findById(id);
		return ResponseEntity.ok().body(categoria);
	}
}
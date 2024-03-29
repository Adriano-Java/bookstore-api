package br.com.ands.bookstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ands.bookstore.domain.Categoria;
import br.com.ands.bookstore.dtos.CategoriaDTO;
import br.com.ands.bookstore.services.CategoriaService;

/**
 * Classe do tipo RestController responsável pelo gerenciamento das categorias
 * de livros via end-points.
 * 
 * A categoria de um livro é representada pela entidade {@Categoria}.
 * 
 * @author Adriano Neto Da Silva
 * @date 12 de out. de 2023
 * @project bookstore-api
 */
@CrossOrigin("*")
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

	/**
	 * Método que recupera uma lista de {@Categoria}, contendo
	 * todas as categorias persistidas na base de dados.
	 * 
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<Categoria> lista = service.findAll();
		List<CategoriaDTO> dto = lista.stream().map(objeto -> new CategoriaDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}
	
	/**
	 * Método que persiste uma nova {@Categoria} na base de dados, enquanto
	 * retorna uma URI de acesso ao novo objeto persistido.
	 * 
	 * @param cat
	 * @return
	 */
	@PostMapping
	public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria cat) {
		cat = service.create(cat);
		URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/categorias/{id}").buildAndExpand(cat.getId()).toUri();
		/*
		 * ResponseEntity.created(uri).body(object): retorna o objeto persistido no corpo da requisição.
		 * ResponseEntity.created(uri).build(): retorna o objeto persistido no headers da requisição.
		 */
		return ResponseEntity.created(uri).build();
	}
	
	/**
	 * Método que atualiza e persiste uma {@Categoria}.
	 * 
	 * @param id
	 * @param dto
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO dto) {
		Categoria novaCategoria = service.update(id, dto);
		return ResponseEntity.ok().body(new CategoriaDTO(novaCategoria));
	}
	
	/**
	 * Método que exclui uma {@Cateporia} da base de dados.
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

package br.com.ands.bookstore.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ands.bookstore.domain.Livro;
import br.com.ands.bookstore.dtos.LivroDTO;
import br.com.ands.bookstore.services.LivroService;

/**
 * Classe do tipo RestController responsável pelo gerenciamento dos livros
 * via end-points.
 * 
 * @author Adriano Neto Da Silva
 * @Date 21 de out. de 2023
 * @Project bookstore
 */
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {
	@Autowired
	private LivroService service;
	
	/**
	 * Método que recupera um {@link Livro} por seu @param id.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Integer id) {
		Livro livro = service.findById(id);
		return ResponseEntity.ok().body(livro);
	}
	
	/**
	 * Método que retorna uma lista de objetos do tipo {@link Livro} por @param id_cat. 
	 * 
	 * @param id_cat
	 * @return
	 */
	@GetMapping
	public ResponseEntity<List<LivroDTO>> findAllByCategoria(@RequestParam(value = "categoria", defaultValue = "0") Integer id_cat) {
		List<Livro> lista = service.findAllByCategoria(id_cat);
		List<LivroDTO> dto = lista.stream().map(livro -> new LivroDTO(livro)).collect(Collectors.toList());
		return ResponseEntity.ok().body(dto);
	}
	
	/**
	 * Método que atualiza os dados de um {@link Livro} via requisição PUT.
	 * 
	 * @param id
	 * @param livro
	 * @return
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livro) {
		Livro livroAtualizado = service.update(id, livro);
		return ResponseEntity.ok().body(livroAtualizado);
	}
	
	/**
	 * Método que atualiza os dados de um {@link Livro} via requisição PATCH.
	 * 
	 * @param id
	 * @param livro
	 * @return
	 */
	@PatchMapping(value = "/atualiza/{id}")
	public ResponseEntity<Livro> updatePath(@PathVariable Integer id, @RequestBody Livro livro) {
		Livro livroAtualizado = service.update(id, livro);
		return ResponseEntity.ok().body(livroAtualizado);
	}
}

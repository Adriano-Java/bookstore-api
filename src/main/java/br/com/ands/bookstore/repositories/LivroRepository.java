package br.com.ands.bookstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ands.bookstore.domain.Livro;

/**
 * 
 * @author Adriano Neto Da Silva
 * @date 23 de jun. de 2021
 * @project bookstore
 */
@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {

	/**
	 * Retorna da base de dados uma lista de objetos do tipo {@link Livro}
	 * via parâmetro.
	 * 
	 * @param id_cat
	 * @return
	 */
	List<Livro> findAllByCategoriaIdOrderByTitulo(Integer id_cat);

}

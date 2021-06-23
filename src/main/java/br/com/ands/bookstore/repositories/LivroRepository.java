package br.com.ands.bookstore.repositories;

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

}

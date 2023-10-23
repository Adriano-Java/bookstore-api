package br.com.ands.bookstore.dtos;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.ands.bookstore.domain.Categoria;

/**
 * DTO para {@Categoria}
 * 
 * @author Adriano Neto Da Silva
 * @Date 13 de out. de 2023
 * @Project bookstore
 */
public class CategoriaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message = "Campo NOME é requirido!")
	@Length(min = 3, max = 100, message = "O campo NOME deve conter entre 3 a 100 caracteres!")
	private String nome;
	
	@NotEmpty(message = "Campo DESCRIÇÃO é requirido!")
	@Length(min = 3, max = 100, message = "O campo DESCRIÇÃO deve conter entre 3 a 100 caracteres!")
	private String descricao;
	
	public CategoriaDTO() {
		super();
	}

	public CategoriaDTO(Categoria cat) {
		super();
		this.id = cat.getId();
		this.nome = cat.getNome();
		this.descricao = cat.getDescricao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}

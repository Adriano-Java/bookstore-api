package br.com.ands.bookstore.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author Adriano Neto Da Silva
 * @date 23 de jun. de 2021
 * @project bookstore
 */
@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 2507864558317470931L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotEmpty(message = "Campo TÍTULO é requirido!")
	@Length(min = 3, max = 100, message = "O campo TÍTULO deve conter entre 3 a 100 caracteres!")
	private String titulo;
	
	@NotEmpty(message = "Campo NOME DO AUTOR é requirido!")
	@Length(min = 3, max = 100, message = "O campo NOME DO AUTOR deve conter entre 3 a 100 caracteres!")
	private String nomeDoAutor;
	
	@NotEmpty(message = "Campo TEXTO é requirido!")
	@Length(min = 10, max = 2000000, message = "O campo TEXTO deve conter entre 10 a 2000000 caracteres!")
	private String texto;
	
	@JsonIgnore
	//Muitos livros para cada {@Categoria}
	@ManyToOne
	//Por padrão, uma coluna para o id categoria é criada, mas pode-se nomear essa coluna com 'name = coluna_id'
	@JoinColumn(name = "categoria_id")
	private Categoria categoria;

	public Livro() {
		super();
	}

	public Livro(Integer id, String titulo, String nomeDoAutor, String texto, Categoria categoria) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.nomeDoAutor = nomeDoAutor;
		this.texto = texto;
		this.categoria = categoria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getNomeDoAutor() {
		return nomeDoAutor;
	}

	public void setNomeDoAutor(String nomeDoAutor) {
		this.nomeDoAutor = nomeDoAutor;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Livro other = (Livro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
} 

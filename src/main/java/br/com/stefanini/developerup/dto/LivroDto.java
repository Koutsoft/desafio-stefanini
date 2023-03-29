package br.com.stefanini.developerup.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class LivroDto {
	private Long id;

	@NotBlank(message = "O nome do livro deve estar preenchido")
	@Size(max = 50, message = "O nome  deve ter no máximo 50 caracteres")
	private String nome;

	@NotBlank(message = "O ano de publicação deve estar preenchido")
	private String anoPublicacao;

	@Size(max = 50, message = "A Editora deve ter no máximo 50 caracteres")
	@NotBlank(message = "O nome da editora deve estar preenchido")
	private String editora;

	@NotBlank(message = "O ISBN deve estar preenchido")
	private String isbn;

	@NotNull(message = "A quantidade deve estar preenchida")
	@Positive(message = " A quantidade não pode ser negativa ou zero")
	private Integer quantidade;

	@NotNull(message = "O id do autor deve estar preenchido")
	private Long idAutor;

	public Long getIdAutor() {
		return idAutor;
	}

	public void setIdAutor(Long idAutor) {
		this.idAutor = idAutor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoPublicacao() {
		return anoPublicacao;
	}

	public void setAnoPublicacao(String anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}

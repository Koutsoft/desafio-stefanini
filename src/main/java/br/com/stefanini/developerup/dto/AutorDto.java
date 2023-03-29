package br.com.stefanini.developerup.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

public class AutorDto {

	private Long id;

	@Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
	@NotBlank(message = "O nome deve estar preenchido")
	private String nome;

	@Email(message = "O email não está valido")
	@NotBlank(message = "O e-mail deve estar preenchido")
	private String email;

	@NotNull(message = "O ISNI não deve estar vazio")
	private Integer isni;

	@Past(message = "A data de nascimento dever no passado")
	@NotNull(message = "A data deve estar preenchido")
	private LocalDate dataNascimento;

	@Size(max = 200, message = "A Biografia deve ter no máximo 200 caracteres")
	@NotBlank(message = "A biografia deve estar preenchido")
	private String biografia;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIsni() {
		return isni;
	}

	public void setIsni(Integer isni) {
		this.isni = isni;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

}
package br.com.stefanini.developerup.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * @author Danilo Dorgam email danilodorgam@gmail.com created 30/03/2022
 * @version 0.1.0
 */
public class ClienteDto {
	@Email(message = "O e-mail não está valido")
	@NotBlank(message = "O e-mail deve estar preenchido")
	private String email;

	@Size(max = 50, message = "O nome deve ter no máximo 50 caracteres")
	@NotBlank(message = "O nome deve estar preenchido")
	private String nome;

	@Pattern(regexp = "^\\([1-9]{2}\\) 9[7-9]{1}[0-9]{3}\\-[0-9]{4}$", message = "padrao de telefone invalido")
	@NotBlank(message = "O telefone deve estar preenchido")
	private String contato;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}
}
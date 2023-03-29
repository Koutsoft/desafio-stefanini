package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.model.Autor;

public class AutorParser {

	public static AutorParser get() {
		return new AutorParser();
	}

	public AutorDto dto(Autor entidade) {
		AutorDto dto = new AutorDto();

		dto.setBiografia(entidade.getBiografia());
		dto.setDataNascimento(entidade.getDataNascimento());
		dto.setEmail(entidade.getEmail());
		dto.setId(entidade.getId());
		dto.setIsni(entidade.getIsni());
		dto.setNome(entidade.getNome());

		return dto;
	}

	public Autor entidade(AutorDto dto) {
		Autor entidade = new Autor();

		entidade.setBiografia(dto.getBiografia());
		entidade.setDataNascimento(dto.getDataNascimento());
		entidade.setEmail(dto.getEmail());
		entidade.setId(dto.getId());
		entidade.setIsni(dto.getIsni());
		entidade.setNome(dto.getNome());

		return entidade;
	}
}
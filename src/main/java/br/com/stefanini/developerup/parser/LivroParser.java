package br.com.stefanini.developerup.parser;

import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Livro;

public class LivroParser {

	public static LivroParser get() {
		return new LivroParser();
	}

	public LivroDto dto(Livro entidade) {
		LivroDto dto = new LivroDto();
		dto.setAnoPublicacao(entidade.getAnoPublicacao());
		dto.setEditora(entidade.getEditora());
		dto.setId(entidade.getId());
		dto.setIsbn(entidade.getIsbn());
		dto.setNome(entidade.getNome());
		dto.setQuantidade(entidade.getQuantidade());
		dto.setIdAutor(entidade.getId());
		return dto;
	}

	public Livro entidade(LivroDto dto) {
		Livro entidade = new Livro();

		entidade.setAnoPublicacao(dto.getAnoPublicacao());
		entidade.setEditora(dto.getEditora());
		entidade.setId(dto.getId());
		entidade.setIsbn(dto.getIsbn());
		entidade.setNome(dto.getNome());
		entidade.setQuantidade(dto.getQuantidade());
		return entidade;
	}
}

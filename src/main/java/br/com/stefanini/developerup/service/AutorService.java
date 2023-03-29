package br.com.stefanini.developerup.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.parser.AutorParser;

@RequestScoped
public class AutorService {

	@Inject
	AutorDao dao;

	public List<AutorDto> listar() {
		return dao.listar().stream().map(AutorParser.get()::dto).collect(Collectors.toList());
	}

	@Transactional
	public void remover(Long id) {
		dao.remover(id);
	}

	@Transactional
	public AutorDto cadastrar(AutorDto autor) {
		validarIsni(autor);
		Autor entidade = AutorParser.get().entidade(autor);
		return AutorParser.get().dto(dao.cadastrar(entidade));

	}

	public AutorDto buscarPorId(Long idAutor) {

		return AutorParser.get().dto(dao.buscarPorId(idAutor));

	}

	@Transactional
	public AutorDto atualizar(AutorDto autor) {
		validarIsni(autor);
		Autor entidade = dao.buscarPorId(autor.getId());
		entidade.setNome(autor.getNome());
		entidade.setBiografia(autor.getBiografia());
		entidade.setDataNascimento(autor.getDataNascimento());
		entidade.setEmail(autor.getEmail());
		entidade.setIsni(autor.getIsni());

		return AutorParser.get().dto(dao.cadastrar(entidade));

	}

	private void validarIsni(AutorDto autor) {
		Autor buscarPorISNI = dao.buscarPorISNI(autor.getIsni());
		if (buscarPorISNI != null) {
			throw new BadRequestException("Já existe um autor com esse ISNI");
		}
	}
}
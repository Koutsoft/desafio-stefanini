package br.com.stefanini.developerup.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

import br.com.stefanini.developerup.dao.AutorDao;
import br.com.stefanini.developerup.dao.LivroDao;
import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.model.Autor;
import br.com.stefanini.developerup.model.Livro;
import br.com.stefanini.developerup.parser.LivroParser;

@RequestScoped
public class LivroService {

	@Inject
	LivroDao dao;

	@Inject
	AutorDao autorDao;

	public List<LivroDto> listar() {
		return dao.listar().stream().map(LivroParser.get()::dto).collect(Collectors.toList());
	}

	@Transactional
	public void remover(Long id) {
		dao.remover(id);
	}

	@Transactional
	public LivroDto cadastrar(LivroDto livro) {
		validarIsbn(livro);
		validarAnoPublicacao(livro);
		Livro entidade = LivroParser.get().entidade(livro);
		Autor autor = autorDao.buscarPorId(livro.getIdAutor());
		entidade.setAutor(autor);
		return LivroParser.get().dto(dao.cadastrar(entidade));

	}

	private void validarIsbn(LivroDto livro) {
		Livro buscarPorISBN = dao.buscarPorISBN(livro.getIsbn());
		if (buscarPorISBN != null) {
			throw new BadRequestException("Já existe um Livro com esse ISBN");

		}
	}

	private void validarAnoPublicacao(LivroDto livro) {
		int anoPulicacao = Integer.parseInt(livro.getAnoPublicacao());
		int anoAtual = LocalDate.now().getYear();
		if (anoPulicacao > anoAtual) {
			throw new BadRequestException("O ano de publicação dever do ano autual ou antes.");
		}
	}

	public LivroDto buscarPorId(Long idLivro) {

		return LivroParser.get().dto(dao.buscarPorId(idLivro));

	}

	@Transactional
	public LivroDto atualizar(LivroDto livro) {
		validarIsbn(livro);
		validarAnoPublicacao(livro);
		Livro entidade = dao.buscarPorId(livro.getId());
		Autor autor = autorDao.buscarPorId(livro.getIdAutor());
		entidade.setAutor(autor);
		entidade.setNome(livro.getNome());
		entidade.setAnoPublicacao(livro.getAnoPublicacao());
		entidade.setIsbn(livro.getIsbn());
		entidade.setQuantidade(livro.getQuantidade());
		return LivroParser.get().dto(dao.cadastrar(entidade));
	}
}

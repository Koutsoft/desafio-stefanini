package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.developerup.model.Livro;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class LivroDao {

	public List<Livro> listar() {
		return Livro.listAll(Sort.by("nome").ascending());
	}

	public void remover(Long id) {
		Livro.deleteById(id);
	}

	public Livro cadastrar(Livro livro) {
		Livro.persist(livro);
		return livro;
	}

	public Livro buscarPorId(Long idLivro) {

		return Livro.findById(idLivro);
	}

	public Livro buscarPorISBN(String isbn) {

		return Livro.find("isbn", isbn).firstResult();
	}
}

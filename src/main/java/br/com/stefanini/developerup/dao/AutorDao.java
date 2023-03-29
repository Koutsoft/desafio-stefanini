package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.developerup.model.Autor;
import io.quarkus.panache.common.Sort;

@RequestScoped
public class AutorDao {

	public List<Autor> listar() {
		return Autor.listAll(Sort.by("nome").ascending());
	}

	public void remover(Long id) {
		Autor.deleteById(id);
	}

	public Autor cadastrar(Autor autor) {
		Autor.persist(autor);
		return autor;
	}

	public Autor buscarPorId(Long idAutor) {

		return Autor.findById(idAutor);
	}

	public Autor buscarPorISNI(Integer isni) {

		return Autor.find("isni",isni).firstResult();
	}
}

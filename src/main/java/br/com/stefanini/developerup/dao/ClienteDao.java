package br.com.stefanini.developerup.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;

import br.com.stefanini.developerup.model.Cliente;
import io.quarkus.panache.common.Sort;

/**
 * @author Danilo Dorgam email danilodorgam@gmail.com created 30/03/2022
 * @version 0.1.0
 */
@RequestScoped
public class ClienteDao {
	public List<Cliente> listar() {
		return Cliente.listAll(Sort.by("nome,email,contato").ascending());
	}

	public void remover(String id) {
		Cliente.deleteById(id);
	}

	public Cliente cadastrar(Cliente cliente) {
		Cliente.persist(cliente);
		return cliente;
	}

	public Cliente buscarPorEmail(String email) {

		return Cliente.findById(email);
	}
}

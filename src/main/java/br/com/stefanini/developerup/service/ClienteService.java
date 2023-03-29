package br.com.stefanini.developerup.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.BadRequestException;

import br.com.stefanini.developerup.dao.ClienteDao;
import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.model.Cliente;
import br.com.stefanini.developerup.parser.ClienteParser;

/**
 * @author Danilo Dorgam email danilodorgam@gmail.com created 30/03/2022
 * @version 0.1.0
 */
@RequestScoped
public class ClienteService {
	@Inject
	ClienteDao dao;

	public List<ClienteDto> listar() {
		return dao.listar().stream().map(ClienteParser.get()::dto).collect(Collectors.toList());

	}

	@Transactional
	public void remover(String id) {
		dao.remover(id);
	}

	@Transactional
	public ClienteDto cadastrar(ClienteDto cliente) {
		Cliente buscarPorEmail = dao.buscarPorEmail(cliente.getEmail());
		if (buscarPorEmail != null) {
			throw new BadRequestException("Já existe um cliente com esse e-mail");
		}
		Cliente entidade = ClienteParser.get().entidade(cliente);
		return ClienteParser.get().dto(dao.cadastrar(entidade));

	}

	public ClienteDto buscarPorId(String email) {

		return ClienteParser.get().dto(dao.buscarPorEmail(email));

	}

	@Transactional
	public ClienteDto atualizar(ClienteDto cliente) {
		Cliente entidade = dao.buscarPorEmail(cliente.getEmail());
		entidade.setNome(cliente.getNome());
		entidade.setContato(cliente.getContato());
		return ClienteParser.get().dto(dao.cadastrar(entidade));

	}
}

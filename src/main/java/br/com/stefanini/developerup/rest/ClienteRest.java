package br.com.stefanini.developerup.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;

import br.com.stefanini.developerup.dto.ClienteDto;
import br.com.stefanini.developerup.service.ClienteService;

/**
 * @author Danilo Dorgam email danilodorgam@gmail.com created 30/03/2022
 * @version 0.1.0
 */
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/cliente")
@RequestScoped

public class ClienteRest {
	@Inject
	ClienteService service;

	@GET
	@Operation(summary = "Listar", description = "Retorna uma lista de Clientes")
	@APIResponse(responseCode = "200", description = "ClienteDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response listar() {
		return Response.status(Response.Status.OK).entity(service.listar()).build();
	}

	@GET
	@Path("/{email}")
	@Operation(summary = "buscarPorID", description = "Retorna um Cliente por Email")
	@APIResponse(responseCode = "200", description = "ClienteDTO", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response buscarPorId(@PathParam("email") String email) {
		return Response.status(Response.Status.OK).entity(service.buscarPorId(email)).build();
	}

	@DELETE
	@Path("/{email}")
	@Operation(summary = "Deletar o cliente", description = "Deletar o cliente")
	@APIResponse(responseCode = "200")
	public Response deletar(@PathParam("email") String email) {
		service.remover(email);
		return Response.status(Response.Status.OK).build();
	}

	@POST

	@Operation(summary = "Cadatrar o clinete", description = "Cadastrar o cliente")
	@APIResponse(responseCode = "200", description = "ClienteDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response cadastrar(@Valid ClienteDto cliente) {

		return Response.status(Response.Status.OK).entity(service.cadastrar(cliente)).build();
	}

	@PUT

	@Operation(summary = "Atualizar o cliente", description = "Atualizar o cliente")
	@APIResponse(responseCode = "200", description = "ClienteDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = ClienteDto.class)) })
	public Response atualizar(@Valid ClienteDto cliente) {

		return Response.status(Response.Status.OK).entity(service.atualizar(cliente)).build();
	}

}

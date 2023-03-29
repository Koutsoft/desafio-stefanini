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

import br.com.stefanini.developerup.dto.AutorDto;
import br.com.stefanini.developerup.service.AutorService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/autor")
@RequestScoped
public class AutorRest {

	@Inject
	AutorService service;

	@GET
	@Operation(summary = "Listar", description = "Retorna uma lista de autores")
	@APIResponse(responseCode = "200", description = "AutorDTO", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AutorDto.class)) })
	public Response listar() {
		return Response.status(Response.Status.OK).entity(service.listar()).build();
	}

	@GET
	@Path("/{id}")
	@Operation(summary = "buscarPorID", description = "Retorna um autor por ID")
	@APIResponse(responseCode = "200", description = "AutorDTO", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AutorDto.class)) })
	public Response buscarPorId(@PathParam("id") Long id) {
		return Response.status(Response.Status.OK).entity(service.buscarPorId(id)).build();
	}

	@DELETE
	@Path("/{id}")
	@Operation(summary = "Deletar o autor", description = "Deletar um autor")
	@APIResponse(responseCode = "200")
	public Response deletar(@PathParam("id") Long id) {
		service.remover(id);
		return Response.status(Response.Status.OK).build();
	}

	@POST

	@Operation(summary = "Cadatrar o Autor", description = "Cadastrar o Autor")
	@APIResponse(responseCode = "200", description = "AutorDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AutorDto.class)) })
	public Response cadastrar(@Valid AutorDto autor) {

		return Response.status(Response.Status.OK).entity(service.cadastrar(autor)).build();
	}

	@PUT

	@Operation(summary = "Atualizar o autor", description = "Atualizar o autor")
	@APIResponse(responseCode = "200", description = "AutorDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = AutorDto.class)) })
	public Response atualizar(@Valid AutorDto autor) {

		return Response.status(Response.Status.OK).entity(service.atualizar(autor)).build();
	}

}
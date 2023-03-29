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

import br.com.stefanini.developerup.dto.LivroDto;
import br.com.stefanini.developerup.service.LivroService;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/livro")
@RequestScoped
public class LivroRest {
	@Inject
	LivroService service;

	@GET
	@Operation(summary = "Listar", description = "Retorna uma lista de livros")
	@APIResponse(responseCode = "200", description = "LivroDTO", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LivroDto.class)) })
	public Response listar() {
		return Response.status(Response.Status.OK).entity(service.listar()).build();
	}

	@GET
	@Path("/{id}")
	@Operation(summary = "buscarPorID", description = "Retorna um livro por ID")
	@APIResponse(responseCode = "200", description = "LivroDTO", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LivroDto.class)) })
	public Response buscarPorId(@PathParam("id") Long id) {
		return Response.status(Response.Status.OK).entity(service.buscarPorId(id)).build();
	}

	@DELETE
	@Path("/{id}")
	@Operation(summary = "Deletar o Livro", description = "Deletar o Livro")
	@APIResponse(responseCode = "200")
	public Response deletar(@PathParam("id") Long id) {
		service.remover(id);
		return Response.status(Response.Status.OK).build();
	}

	@POST

	@Operation(summary = "Cadatrar Livro", description = "Cadastrar Livro")
	@APIResponse(responseCode = "200", description = "LivroDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LivroDto.class)) })
	public Response cadastrar(@Valid LivroDto livro) {

		return Response.status(Response.Status.OK).entity(service.cadastrar(livro)).build();
	}

	@PUT

	@Operation(summary = "Atualizar o Livro", description = "Atualizar o Livro")
	@APIResponse(responseCode = "200", description = "LivroDto", content = {
			@Content(mediaType = "application/json", schema = @Schema(implementation = LivroDto.class)) })
	public Response atualizar(@Valid LivroDto livro) {

		return Response.status(Response.Status.OK).entity(service.atualizar(livro)).build();
	}

}

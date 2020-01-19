package be.pengo.tomeeapi.services;

import javax.ejb.Stateless;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import be.pengo.tomeeapi.controllers.ContactController;
import be.pengo.tomeeapi.entities.Contact;
import be.pengo.tomeeapi.exceptions.ContactDupplicatedException;
import be.pengo.tomeeapi.exceptions.ContactNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/contacts")
@Stateless
@Consumes("application/json")
@Produces("application/json; charset=UTF-8")
@Api("contact")
public class ContactService {

	@Inject
	private ContactController service;

	@DELETE
	@Path("/{id}")
	@ApiOperation(value = "Delete contact.")
	public Response deleteContact(final @PathParam("id") @ApiParam(value = "contact id") Long id){
		try {
			service.remove(id);
			return Response.ok().build();
	    } catch (ContactNotFoundException cnfe){
	    	return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
	}

	@PUT
	@Path("/{id}")
	@ApiOperation(value = "Update contact.")
	public Response updateContact(@Valid Contact contact){
		return Response.status(Response.Status.OK).entity(service.upadte(contact)).build();
	}

	@POST
	@ApiOperation(value = "Save contact.")
	public Response saveContact(@Valid Contact contact){
		try {
			return Response.status(Response.Status.CREATED).entity(service.save(contact)).build();
		} catch (ContactDupplicatedException cde){
	    	return Response.status(Response.Status.CONFLICT)
	        		.entity("Other contact already uses email: " + contact.getEmail()).build();
	    }
	}

	@GET
	@ApiOperation(value = "List contacts.")
	public Response getContacts(final @QueryParam("offset") @ApiParam(value = "offset") Integer offset,
			final @QueryParam("limit") @ApiParam(value = "limit") Integer limit) {
		return Response.ok(service.getAll(offset, limit))
				.header("X-Total-Count", service.count()).build();
	}

	@GET
	@Path("/{id}")
	@ApiOperation(value = "Get a contact.")
	public Response getContact(final @PathParam("id") @ApiParam(value = "contact id") Long id) {
		if(service.getById(id) == null) {
	        return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
		return Response.ok(service.getById(id)).build();
	}

}

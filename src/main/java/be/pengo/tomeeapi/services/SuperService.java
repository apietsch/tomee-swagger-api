package be.pengo.tomeeapi.services;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/super")
@Api("super")
@Produces("application/text; charset=UTF-8")
@Stateless
public class SuperService {
    
    @PersistenceContext(unitName = "myPU")
    private EntityManager entityManager;
    
    @GET
    @ApiOperation("My tiny hello world service.")
    public Response helloWorld() {
        return Response.ok().entity("Hello World").build();
    }
}

package be.pengo.tomeeapi.services;

import java.util.List;

import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

import be.pengo.tomeeapi.dao.RegionDao;
import be.pengo.tomeeapi.entities.Region;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Path("/api/regions")
@Stateless
@Consumes("application/json")
@Produces("application/json; charset=UTF-8")
@Api("region")
@RolesAllowed(value = "user")
public class RegionService {

	@Inject
    RegionDao regionDao;

	@GET
	@ApiOperation(value = "Find regions.")
	public List<Region> findRegions(
			@QueryParam("nameQuery") @ApiParam(value = "region name") String nameQuery,
			@QueryParam("number") @ApiParam(value = "page size", defaultValue = "20") @DefaultValue("20") final int number,
			@QueryParam("offset") @ApiParam(value = "item offset", defaultValue = "0") @DefaultValue("0") final int offset) {
		return regionDao.findAll(nameQuery, offset, number);
	}

	@GET
    @Path("{id}")
    @ApiOperation(value = "Find a region by id.")
    public Region get(@PathParam("id") @ApiParam(value = "region id", required = true) final long regionId) {
        return regionDao.find(regionId);
    }

}

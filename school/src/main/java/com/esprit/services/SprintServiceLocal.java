package com.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.persistance.Sprint;

@Local
@Path("/sprint")
public interface SprintServiceLocal {

	@POST
	@Path("/addsprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void createSprint(Sprint sprint);
	
	@GET
	@Path("/finddegreebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Sprint findSprintById(@PathParam("id")int id);
	
	@PUT
	@Path("/updatesprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void updateSprint(Sprint sprint);
	
	@GET
	@Path("/listsprint")
	@Produces(MediaType.APPLICATION_JSON)
	List<Sprint> findAllSprints();
	
	@DELETE
	@Path("/deletesprint")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void deleteSprint(Sprint sprint);

}

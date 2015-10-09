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
import com.esprit.persistance.Degree;

@Local
@Path("degree")
public interface DegreeServiceLocal {
	
	@GET
	public String hello();
	
	@GET
	@Path("listdegree")
	@Produces(MediaType.APPLICATION_JSON)
	List<Degree> findAllDegrees();
	
	@POST
	@Path("adddegree")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void createDegree(Degree degree);
	
	@GET
	@Path("finddegreebyid/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Degree findDegreeById(@PathParam("id")int id);
	
	
	@GET
	@Path("finddegreebyName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	Degree findDegreeByName(@PathParam("name")String name);
	
	@PUT
	@Path("/updatedegree")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    void updateDegree(Degree degree);
    
    @DELETE
	@Path("deletedegree")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
    void deleteDegree(Degree degree);

	

}

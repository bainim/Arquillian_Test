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

import com.esprit.persistance.Team;

@Local
@Path("/team")
public interface TeamServiceLocal {


	@POST
	@Path("/addteam")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void createTeam(Team team);
	
	@PUT
	@Path("/updateteam")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void updateTeam(Team team);
	@GET
	@Path("/listteam")
	@Produces(MediaType.APPLICATION_JSON)
	List<Team> findAllTeams();
	
	@GET
	@Path("/findteambyName/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	Team findTeamByName(@PathParam("name")String name);
	
	@DELETE
	@Path("/deleteteam")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void deleteTeam(Team team);
}

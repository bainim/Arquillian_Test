package com.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.persistance.Team;

@Remote
public interface TeamServiceRemote {

	void createTeam(Team team);
	void updateTeam(Team team);
	List<Team> findAllTeams();
	Team findTeamByName(String name);
	void deleteTeam(Team team);
}

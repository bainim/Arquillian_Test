package com.esprit.services;

import java.util.List;

import javax.ejb.Remote;


import com.esprit.persistance.Sprint;

@Remote
public interface SprintServiceRemote {

	void createSprint(Sprint sprint);
	Sprint findSprintById(int id);
	void updateSprint(Sprint sprint);
	List<Sprint> findAllSprints();
	void deleteSprint(Sprint sprint);
}

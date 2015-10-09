package com.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.persistance.Degree;

@Remote
public interface DegreeServiceRemote {
	
	void createDegree(Degree degree);
	Degree findDegreeById(int id);
	void updateDegree(Degree degree);
	List<Degree> findAllDegrees();
    Degree findDegreeByName(String Name);
    void deleteDegree(Degree degree);
}

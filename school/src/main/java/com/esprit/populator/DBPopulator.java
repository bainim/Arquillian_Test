package com.esprit.populator;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.esprit.persistance.Degree;
import com.esprit.persistance.Sprint;
import com.esprit.persistance.Student;
import com.esprit.persistance.Team;
import com.esprit.services.DegreeServiceLocal;
import com.esprit.services.SprintServiceLocal;
import com.esprit.services.StudentServiceLocal;
import com.esprit.services.TeamServiceLocal;


@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	private DegreeServiceLocal degreeService;
	
	@EJB
	private TeamServiceLocal teamService;
	
	@EJB
	private StudentServiceLocal studentService;
	
	@EJB
	private SprintServiceLocal sprintService;
	
	
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void populateDB(){
		Degree degree1 = new Degree();
		degree1.setName("4INFOB3");
		degreeService.createDegree(degree1);	
		
		
		Team team1 = new Team();
		team1.setName("Coders");
		team1.setDegree(degree1);
		teamService.createTeam(team1);
		
		Student student1 = new Student();
		student1.setDegree(degree1);
		student1.setFirstname("marwen");
		student1.setLastname("baini");
		student1.setTeam(team1);
		studentService.creatStudent(student1);
		
		Sprint sprint1 = new Sprint();
		sprint1.setMaitrise(10);
		sprint1.setNfinal(14);
		sprint1.setQalite(12);
		sprint1.setRealisation(13);
		sprint1.setRemarque("bon");
		sprint1.setTeam(team1);
		sprintService.createSprint(sprint1);
		
		
	}

}

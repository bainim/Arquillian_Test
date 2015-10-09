package com.esprit.persistance;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "t_student")
public class Student implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstname;
	private String lastname;
	private Degree degree;
	private Team team;
	
	public Student() {
	}
	
	public Student(String firstname, String lastname,
			Degree degree, Team team) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.degree = degree;
		this.team = team;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@ManyToOne
	@JoinColumn(name = "degreestudent_fk")
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
	@ManyToOne
	@JoinColumn(name = "teamstudent_fk")
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	
	
	
	
}

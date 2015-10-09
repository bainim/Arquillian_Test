package com.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

@Entity
@Table(name ="t_degree")
@JsonPropertyOrder
public class Degree implements Serializable {

	
	
	
	private int id;
	private String name;
	private List<Team> team;
	private List<Student> student;
	private static final long serialVersionUID = 1L;
	
	
	public Degree(String name) {
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	@OneToMany(mappedBy = "degree", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Team> getTeam() {
		return team;
	}
	public void setTeam(List<Team> team) {
		this.team = team;
	}
	
	public Degree() {
	}
	
	
	
	
}

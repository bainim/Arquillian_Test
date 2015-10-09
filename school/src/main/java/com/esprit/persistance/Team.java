package com.esprit.persistance;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonPropertyOrder;


@Entity
@Table(name="t_team")
@JsonPropertyOrder
public class Team implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private List<Student> student;
	private Degree degree;
	private List<Sprint> sprint;
	
	public Team() {
	}

	public Team(String name, Degree degree) {
		super();
		this.name = name;
		this.degree = degree;
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
	
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> student) {
		this.student = student;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "degreeteam_fk")
	public Degree getDegree() {
		return degree;
	}
	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	@OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
	@JsonIgnore
	public List<Sprint> getSprint() {
		return sprint;
	}
	public void setSprint(List<Sprint> sprint) {
		this.sprint = sprint;
	}
	
	

}

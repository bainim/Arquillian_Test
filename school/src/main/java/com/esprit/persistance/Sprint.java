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
@Table(name ="t_sprint")
public class Sprint implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Team team;
	private float Maitrise,Realisation,Qalite,Nfinal;
	private String remarque;
	
	public Sprint() {
	}
	public Sprint(Team team, float maitrise, float realisation, float qalite,
			float nfinal, String remarque) {
		super();
		this.team = team;
		Maitrise = maitrise;
		Realisation = realisation;
		Qalite = qalite;
		Nfinal = nfinal;
		this.remarque = remarque;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	@JoinColumn(name = "teamsprint_fk")
	public Team getTeam() {
		return team;
	}
	public void setTeam(Team team) {
		this.team = team;
	}
	public float getMaitrise() {
		return Maitrise;
	}
	public void setMaitrise(float maitrise) {
		Maitrise = maitrise;
	}
	public float getRealisation() {
		return Realisation;
	}
	public void setRealisation(float realisation) {
		Realisation = realisation;
	}
	public float getQalite() {
		return Qalite;
	}
	public void setQalite(float qalite) {
		Qalite = qalite;
	}
	public float getNfinal() {
		return Nfinal;
	}
	public void setNfinal(float nfinal) {
		Nfinal = nfinal;
	}
	public String getRemarque() {
		return remarque;
	}
	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}
	

}

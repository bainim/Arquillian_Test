package com.esprit.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.esprit.persistance.Team;


@Stateless
public class TeamService implements TeamServiceRemote, TeamServiceLocal {

	@PersistenceContext(unitName = "school")
	private EntityManager em;
    public TeamService() {
    }

    @Override
	public void createTeam(Team team) {

		em.persist(team);
		
	}

	@Override
	public void updateTeam(Team team) {
		em.merge(team);		
	}

	

	@Override
	public List<Team> findAllTeams() {
		return em.createQuery("select s from Team s  ", Team.class)
				.getResultList();
	}

	
	public Team findTeamByName(String name) {
		
		String jpql = "select s from Team s where s.name = :x ";
		Query query = em.createQuery(jpql);
		query.setParameter("x", name);

		return  (Team) query.getSingleResult();
	}

	
	public void deleteTeam(Team team) {
		em.remove(em.merge(team));
		
	}

	public void saveOrUpdateteam(Team team) {
		em.merge(team);
	}

}

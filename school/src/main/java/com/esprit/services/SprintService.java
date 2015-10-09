package com.esprit.services;

import java.util.List;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.esprit.persistance.Sprint;


@Stateless
public class SprintService implements SprintServiceRemote, SprintServiceLocal {

	@PersistenceContext(unitName = "school")
	private EntityManager em;
    
    public SprintService() {
    }
    
    @Override
	public void createSprint(Sprint sprint) {

		em.persist(sprint);
		
	}

	@Override
	public Sprint findSprintById(int id) {
		return em.find(Sprint.class, id);
	}

	@Override
	public void updateSprint(Sprint sprint) {
		em.merge(sprint);		
	}

	

	@Override
	public List<Sprint> findAllSprints() {
		return em.createQuery("select s from Sprint s  ", Sprint.class)
				.getResultList();
	}

	
	
	public void deleteSprint(Sprint sprint) {
		em.remove(em.merge(sprint));
		
	}

	public void saveOrUpdatesprint(Sprint sprint) {
		em.merge(sprint);
	}

}

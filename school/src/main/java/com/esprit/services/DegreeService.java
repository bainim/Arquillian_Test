package com.esprit.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;



import com.esprit.persistance.Degree;


@Stateless
public class DegreeService implements DegreeServiceRemote, DegreeServiceLocal {

	@PersistenceContext(unitName = "school")
	private EntityManager em;
    
    public DegreeService() {
    }
    
    @Override
	public void createDegree(Degree degree) {

		em.persist(degree);
		
	}

	@Override
	public Degree findDegreeById(int id) {
		return em.find(Degree.class, id);
	}

	@Override
	public void updateDegree(Degree degree) {
		em.merge(degree);		
	}

	

	@Override
	public List<Degree> findAllDegrees() {
		return em.createQuery("select s from Degree s  ", Degree.class)
				.getResultList();
	}

	
	public Degree findDegreeByName(String name) {
		
		String jpql = "select s from Degree s where s.name = :x ";
		Query query = em.createQuery(jpql);
		query.setParameter("x", name);

		return  (Degree) query.getSingleResult();
	}

	
	public void deleteDegree(Degree degree) {
		em.remove(em.merge(degree));
		
	}

	public void saveOrUpdatedegree(Degree degree) {
		em.merge(degree);
	}

	@Override
	public String hello() {
		return "hellooo";
	}

}

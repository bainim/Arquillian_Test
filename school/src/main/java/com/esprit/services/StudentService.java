package com.esprit.services;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.esprit.persistance.Student;


@Stateless
public class StudentService implements StudentServiceRemote, StudentServiceLocal {

	@PersistenceContext(unitName = "school")
	private EntityManager em;
	
    public StudentService() {
    }
    
    @Override
   	public void creatStudent(Student student) {
   		em.persist(student);	
   	}


   	@Override
   	public void updateStudent(Student student) {
   		em.merge(student);		
   	}
   	@Override
   	public List<Student> findAllStudents() {
   		return em.createQuery("select s from Student s  ", Student.class)
   				.getResultList();
   	}
   	public Student findStudentByfirstName(String firstname) {
   		
   		String jpql = "select s from Student s where s.firstname = :x ";
   		Query query = em.createQuery(jpql);
   		query.setParameter("x", firstname);

   		return  (Student) query.getSingleResult();
   	}
   	
    public Student findStudentBylastName(String lastname) {
   		
   		String jpql = "select s from Student s where s.lastname = :x ";
   		Query query = em.createQuery(jpql);
   		query.setParameter("x", lastname);

   		return  (Student) query.getSingleResult();
   	}

   	
   	public void deleteStudent(Student student) {
   		em.remove(em.merge(student));
   		
   	}

   	public void saveOrUpdatestudent(Student student) {
   		em.merge(student);
   	}

}

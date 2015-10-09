package com.esprit.services;

import java.util.List;

import javax.ejb.Remote;

import com.esprit.persistance.Student;

@Remote
public interface StudentServiceRemote {
	
	void creatStudent(Student student);
	void updateStudent(Student student);
	List<Student> findAllStudents();
	Student findStudentByfirstName(String firstname);
	Student findStudentBylastName(String lastname);
	void deleteStudent(Student student);

}

package com.esprit.services;

import java.util.List;

import javax.ejb.Local;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.esprit.persistance.Student;

@Local
@Path("/student")
public interface StudentServiceLocal {

	@POST
	@Path("/addstudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void creatStudent(Student student);
	
	@PUT
	@Path("/updatestudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void updateStudent(Student student);
	
	
	@GET
	@Path("/liststudent")
	@Produces(MediaType.APPLICATION_JSON)
	List<Student> findAllStudents();
	
	@GET
	@Path("/findstudentByfirstName/{firstname}")
	@Produces(MediaType.APPLICATION_JSON)
	Student findStudentByfirstName(@PathParam("firstname")String firstname);
	@GET
	@Path("/findstudentBylastName/{lastname}")
	@Produces(MediaType.APPLICATION_JSON)
	Student findStudentBylastName(@PathParam("lastname")String lastname);
	
	@DELETE
	@Path("/deletestudent")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	void deleteStudent(Student student);

}

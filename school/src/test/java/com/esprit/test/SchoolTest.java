package com.esprit.test;

import static org.junit.Assert.assertNotNull;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.esprit.persistance.Student;
import com.esprit.services.StudentService;
import com.esprit.util.Resources;

@RunWith(Arquillian.class)
public class SchoolTest {

	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "schooltest.war")
				.addClasses(Student.class, StudentService.class,
						Resources.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("META-INF/test-ds.xml");
	}

	@Inject
	StudentService studentService;

	@Inject
	Logger log;

	@Test
	public void testIsDeployed() {
		Assert.assertNotNull(studentService);
	}

	@Test
	public void schooltest() {
		System.out.println("In JSFUnit Test Case!! ");
	}

	/*
	 * 
	 * @Test public void schooltest() throws Exception { Student newStudent =
	 * new Student(); newStudent.setFirstname("marwen");
	 * newStudent.setLastname("baini"); studentService.creatStudent(newStudent);
	 * assertNotNull(newStudent.getLastname());
	 * 
	 * log.info(newStudent.getFirstname() + " was persisted with Last Name " +
	 * newStudent.getLastname()); }
	 */

}

/**
 * 
 */
package edu.bedelias.services.tests;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;

/**
 * @author Gas
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest-c3p0.xml"})
public class StudentTest {

	@Autowired
	private StudentService studentService;

	@Test
	public void test() {
		Student student = new Student();
		student.setName("Chupito");
		student.setEmail("chupame@eltobonia.net");
		student.setCedula("someCedula");
		student.setFechaInscripcionFac(new Date(System.currentTimeMillis()));

		student = studentService.createStudent(student);
		
		assertNotNull("Student can't be null", student);
		assertEquals("Email must be the same", student.getEmail(),
				"chupame@eltobonia.net");
	}

	// Getters && Setters

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}

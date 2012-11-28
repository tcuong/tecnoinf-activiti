package edu.bedelias.remoting;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.services.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class StudentServiceTest extends ServerRunner {

	@Autowired
	private StudentService studentService;

	@Test
	public void testDateService() {
		assertNotNull("Must have autowired repositories", studentService);
		System.out.println(studentService.existeStudentByCedula("someCedula"));
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}
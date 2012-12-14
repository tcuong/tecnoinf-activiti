package edu.bedelias.tests.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;
import edu.bedelias.utils.ReportsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class ActaTest {

	private List<Student> estudiantes;
	private Curso curso;
	
	
	@Before
	public void init() {
		Student s1 = new Student("Chuck Norris", "gmail@norris.com", "0.000.000-0", new Date());
		Student s2 = new Student("Bruno Viera Guerra", "parker@dailyGlobe.com", "3.762.767-3", new Date());
		s1.setPassword("hashMe");
		s2.setPassword("letmein");
		
		estudiantes = new ArrayList<Student>();
		estudiantes.add(s1);
		estudiantes.add(s2);
		
		this.curso = new Curso();
		curso.setName("Calculo 1");
	}
	
	@Test
	public void test() {
		// ReportsService.print(); // FIXME completar la API
		ReportsService.imprimirActaCurso(estudiantes, curso);
	}

}

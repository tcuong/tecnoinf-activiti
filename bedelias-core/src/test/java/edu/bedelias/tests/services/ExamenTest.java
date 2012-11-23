package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Examen;
import edu.bedelias.services.ExamenService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
public class ExamenTest {
	
	@Autowired
	private ExamenService examenService;
	
	@Test
	public void test(){
		
		Examen examen = new Examen();

		examen = examenService.createExamen(examen);
		
		assertNotNull("Examen can't be null", examen);
			
	}

}

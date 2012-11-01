package edu.bedelias.services.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.services.PeriodoInscripcionService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class PeriodoInscripcionTest {
	
	@Autowired
	private PeriodoInscripcionService service;
	
	@Test
	public void test(){
		
		PeriodoInscripcion inscripcion = new PeriodoInscripcion();
		
		inscripcion = service.createPeriodoInscripcion(inscripcion);
		
		assertNotNull("PeriodoInscripcion can't be null", inscripcion);
		
	}

}

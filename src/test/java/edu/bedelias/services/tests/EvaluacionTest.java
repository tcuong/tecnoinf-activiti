package edu.bedelias.services.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.services.EvaluacionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class EvaluacionTest{

	@Autowired
	private EvaluacionService evaluacionService;
	
	@Test
	public void test(){

		Evaluacion evaluacion = new Evaluacion();

		evaluacion = evaluacionService.createEvaluacion(evaluacion);
		
		assertNotNull("Asignatura can't be null", evaluacion);
		
	}

	
}

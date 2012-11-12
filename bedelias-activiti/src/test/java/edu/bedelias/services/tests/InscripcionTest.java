package edu.bedelias.services.tests;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Inscripcion;
import edu.bedelias.services.InscripcionService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest.xml" })
public class InscripcionTest {

	@Autowired
	private InscripcionService inscripcionService;

	@Test
	public void test() {
		Inscripcion inscripcion = new Inscripcion();
		inscripcion = inscripcionService.createInscripcion(inscripcion);

		assertNotNull("Inscripcion can't be null", inscripcion);

	}

}

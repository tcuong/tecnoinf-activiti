package edu.bedelias.tests.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.services.AsignaturaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class AsignaturaTest {

	@Autowired
	private AsignaturaService asignaturaService;

	@Test
	public void test() {

		Asignatura previa = new Asignatura();
		previa.setCode("soyPrevia");
		previa.setName("CHUKU");
		previa = asignaturaService.createAsignatura(previa);

		Asignatura asignatura = new Asignatura();
		asignatura.setName("Platilina 101");
		asignatura.setCode("elcodigooo");

		asignaturaService.agregarPreviaAsignatura(asignatura, previa);

	}

}

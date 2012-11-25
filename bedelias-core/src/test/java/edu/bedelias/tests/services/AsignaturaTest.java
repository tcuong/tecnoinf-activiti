package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

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

		asignatura = asignaturaService.agregarPreviaAsignatura(asignatura,
				previa);

		List<Asignatura> asignaturasPrevias = asignaturaService
				.getPrevias(asignatura.getId());
		Asignatura checkPrevia = asignaturasPrevias.get(0);

		assertNotNull("Las previas del sistema no pueden ser NULL", checkPrevia);

	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

}

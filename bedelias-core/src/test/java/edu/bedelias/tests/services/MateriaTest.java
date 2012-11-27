package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Materia;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.MateriaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class MateriaTest {

	@Autowired
	private MateriaService materiaService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Test
	public void test() {

		Asignatura asignatura = new Asignatura();
		asignatura.setCode("asigCode");
		asignatura.setName("Una Asignatura");

		asignatura = asignaturaService.createAsignatura(asignatura);

		Materia materia = new Materia();
		materia.setName("Didactica");
		materia.setCode("codigoMateria");

		materia = materiaService.agregarAsignaturaMateria(materia, asignatura);

		List<Asignatura> asigs = materiaService
				.getAsignaturasByMateriaId(materia.getId());

		assertNotNull("Materia can't be null", materia);
		for (Asignatura a : asigs) {
			assertNotNull("Asignaturas can't be null", a);
		}

	}

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

}

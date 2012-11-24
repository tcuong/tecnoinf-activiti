package edu.bedelias.tests.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Materia;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.MateriaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class CarreerTest {

	@Autowired
	private CarreerService carreerService;

	@Autowired
	private MateriaService materiaService;

	@Test
	public void test() {

		Materia materia1 = new Materia();
		materia1.setName("Juliana");
		materia1.setCode("codigo");
		materia1 = materiaService.createMateria(materia1);

		Carreer carreer = new Carreer("Alguna carrera");
		carreer.setCode("lalalla");
		carreer = carreerService.agregarMateriaACarrera(carreer, materia1);

		// List<Materia> materias =
		// carreerService.findMateriaByCarreerId(carreer
		// .getId());
		// assertNotNull("Lista de materias no puede ser nula", materias);

	}

	public CarreerService getCarreerService() {
		return carreerService;
	}

	public void setCarreerService(CarreerService carreerService) {
		this.carreerService = carreerService;
	}

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

}

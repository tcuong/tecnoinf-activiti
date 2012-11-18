package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

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

		Materia materia2 = new Materia();
		materia2.setName("Milton");
		materia2.setCode("codigoasas");

		materia1 = materiaService.createMateria(materia1);
		materia2 = materiaService.createMateria(materia2);

		List<Materia> materias = new ArrayList<Materia>();
		materias.add(materia1);
		materias.add(materia2);

		Carreer carreer = new Carreer("Alguna carrera");
		carreer.setCode("lalalla");

		carreer.setMaterias(materias);
		carreer = carreerService.createCarreer(carreer);

		List<Materia> materiasFromDB = carreerService
				.findMateriaByCarreerId(carreer.getId());

		// List<Materia> materiasFromDB = carreerService
		// .findMateriaByCarreerId(carreer.getId());

		assertEquals("No hay 2 materias", materiasFromDB.size(), 2);

		assertNotNull("Carreer can't be null", carreer);
		assertNotNull("Carreer Name can't be null", carreer.getName());
		assertNotNull("Carreer Code can't be null", carreer.getCode());

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

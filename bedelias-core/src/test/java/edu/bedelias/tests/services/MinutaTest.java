package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Materia;
import edu.bedelias.entities.Minuta;
import edu.bedelias.entities.SolicitudAsignatura;
import edu.bedelias.services.MateriaService;
import edu.bedelias.services.MinutaService;
import edu.bedelias.services.SolicitudAsignaturaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class MinutaTest {

	@Autowired
	private SolicitudAsignaturaService solicitudAsignaturaService;

	@Autowired
	private MinutaService minutaService;

	@Autowired
	private MateriaService materiaService;

	@Test
	public void test() {
		Materia materia = new Materia();
		materia.setName("Didactica");
		materia.setCode("codigoMateria");
		materia = materiaService.createMateria(materia);

		SolicitudAsignatura solAsig = new SolicitudAsignatura();
		solAsig.setCedulaDocente("cedulaDocente");
		solAsig.setNombreAsignatura("nombreAsignatura");
		solAsig.setNombreDocente("nombreDocente");
		solAsig.setPropuesta("propuesta");

		// solAsig = solicitudAsignaturaService.createSolicitud(solAsig,
		// materia);

		Minuta minuta = new Minuta();
		minuta.setAprobado(true);
		minuta.setNombreEntidad("Instituto");
		minuta.setNombreFuncionario("nombreFuncionario");
		minuta.setResolucion("resolucion");

		// minuta = minutaService.createMinuta(minuta, solAsig);

		Minuta minuta1 = new Minuta();
		minuta1.setAprobado(false);
		minuta1.setNombreEntidad("Institutowww");
		minuta1.setNombreFuncionario("nombreFuncionarassio");
		minuta1.setResolucion("resolucidsdson");

		// minuta = minutaService.createMinuta(minuta1, solAsig);

		assertNotNull("Las previas del sistema no pueden ser NULL", minuta);

	}

	public SolicitudAsignaturaService getSolicitudAsignaturaService() {
		return solicitudAsignaturaService;
	}

	public void setSolicitudAsignaturaService(
			SolicitudAsignaturaService solicitudAsignaturaService) {
		this.solicitudAsignaturaService = solicitudAsignaturaService;
	}

	public MinutaService getMinutaService() {
		return minutaService;
	}

	public void setMinutaService(MinutaService minutaService) {
		this.minutaService = minutaService;
	}

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}
}

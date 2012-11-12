/**
 * 
 */
package edu.bedelias.services.tests;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoEvaluacionEnum;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

/**
 * @author Gas
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class StudentTest {

	@Autowired
	private StudentService studentService;

	@Autowired
	private EvaluacionService evaluacionService;

	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private CarreerService carreraService;

	private Student student;
	private Evaluacion evaluacion;
	private Inscripcion inscripcion;
	private List<Carreer> carreras;

	@Before
	public void init() {

		student = new Student();
		student.setName("Chupito");
		student.setEmail("chupame@eltobonia.net");
		student.setCedula("someCedula");
		student.setFechaInscripcionFac(new Date(System.currentTimeMillis()));

		student = studentService.createStudent(student);

	}

	@Test
	public void test() {

		evaluacion = new Evaluacion();
		evaluacion.setResultado(8);
		evaluacion.setTipoEvaluacion(TipoEvaluacionEnum.PARCIAL);

		evaluacion = evaluacionService.createEvaluacion(evaluacion);

		evaluacion.setEstudiante(student);
		evaluacionService.updateEvaluacio(evaluacion);

		student = studentService.findStudentByCedula("someCedula");
		Student julio = studentService.findStudentByCedula(student.getCedula());
		Evaluacion eval2 = evaluacionService.getEvaluacionesByStudentId(julio)
				.get(0);

		assertNotNull("Student can't be null", student);
		assertEquals("Email must be the same", student.getEmail(),
				"chupame@eltobonia.net");
		assertEquals("Evaluaciones deben ser iguales", evaluacion.getId(),
				eval2.getId());
	}

	@Ignore
	@Test
	public void test2() {

		student = studentService.findStudentByCedula("someCedula");
		Student julio = studentService.findStudentByCedula(student.getCedula());

		carreras = new ArrayList<Carreer>();

		carreras.add(this.crearCarreer("Mamadera Negra"));
		carreras.add(this.crearCarreer("Mamadera Bionica"));
		carreras.add(this.crearCarreer("Saca Caca"));

		List<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

		for (int i = 0; i < carreras.size(); i++) {
			inscripciones.add(this.crearInscripcion());
		}

		for (int i = 0; i < inscripciones.size(); i++) {
			inscripciones.get(i).setCarrera(carreras.get(i));
			inscripcionService.updateInscripcion(inscripciones.get(i));
		}

		List<Carreer> masCarreras = inscripcionService
				.getCarrerasByStudent(julio);

		if (masCarreras.size() == 0) {

			org.junit.Assert.fail("Listas de carreras vacias");
		}
		for (int i = 0; i < masCarreras.size(); i++) {
			assertEquals("Las carreras deben ser iguales", carreras.get(i)
					.getId(), masCarreras.get(i).getId());
		}
	}

	private Carreer crearCarreer(String nombreCarrera) {

		UUID code = UUID.randomUUID();
		Carreer carreer = new Carreer();
		carreer.setName(nombreCarrera);
		carreer.setCode(code);

		carreer = carreraService.createCarreer(carreer);

		return carreer;
	}

	private Inscripcion crearInscripcion() {
		inscripcion = new Inscripcion();
		inscripcion.setTipo(TipoInscripcionEnum.CARRERA);
		inscripcionService.createInscripcion(inscripcion);

		inscripcion.setEstudiante(student);
		inscripcionService.updateInscripcion(inscripcion);

		return inscripcion;
	}

	// Getters && Setters

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}

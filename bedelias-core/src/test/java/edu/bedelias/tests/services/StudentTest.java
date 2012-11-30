/**
 * 
 */
package edu.bedelias.tests.services;

//import static org.junit.Assert.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoEvaluacionEnum;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.CursoService;
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

	@Autowired
	private CursoService cursoService;

	@Before
	public void init() {
		Student student = studentService.createStudent(new Student("Chupito",
				"chupame@eltobonia.net", "someCedula", new Date(System
						.currentTimeMillis())));

		List<Carreer> carreras = new ArrayList<Carreer>();
		carreras.add(new Carreer("Ingenieria Mecanica"));
		carreras.add(new Carreer("Ingenieria Civil"));
		carreras.add(new Carreer("Ingenieria Quimica"));
		carreras.add(new Carreer("Ingenieria Computacion"));

		carreraService.createCarreer(carreras);

		carreras = carreraService.findAll();

		for (Carreer c : carreras) {
			// FIXME inscripcionService.InscripcionACarrera(student.getId(),
			// c.getId());
		}

		Curso curso = new Curso();
		curso.setName("Plastilina 101 vesp.");
		curso.setSemestre("Par");
		curso.setHorario("Los jueves de 9 a 10:30");
		curso.setFechaInicio(new Date(System.currentTimeMillis()));
		curso.setFechaFin(new Date(System.currentTimeMillis()));
		curso.setTurno(TurnoEnum.VESPERTINO);

		// curso = cursoService.createCurso(curso); FIXME se agrego al crear
		// curso, meterle una asignatura

		// FIXME inscripcionService.InscripcionACurso(student.getId(),
		// curso.getId());

		return;
	}

	@Test
	public void testEvaluacion() {
		Evaluacion eval = new Evaluacion();
		eval.setTipoEvaluacion(TipoEvaluacionEnum.PARCIAL);
		eval.setResultado(8);

		Student student = studentService.findStudentByCedula("someCedula");

		assertNotNull("Student can't be null", student);
		assertEquals("Email must be the same", student.getEmail(),
				"chupame@eltobonia.net");

		// eval = evaluacionService.createEvaluacion(eval,
		// student.getId());FIXME esto ya no va mas aca

		Evaluacion eval2 = evaluacionService
				.getEvaluacionesByStudentId(student).get(0);

		assertEquals("Evaluaciones deben ser iguales", eval.getId(),
				eval2.getId());
	}

	@Test
	public void testCarreras() {
		Student student = studentService.findStudentByCedula("someCedula");
		List<Carreer> carreras = inscripcionService
				.getCarrerasByStudent(student);

		if (carreras.size() == 0) {
			org.junit.Assert.fail("Lista de carreras vacia");
		}

		List<Carreer> allCarreers = carreraService.findAll();
		assertNotNull("Las carreras del sistema no pueden ser NULL",
				allCarreers);

		for (Carreer c : carreras) {
			assertNotNull("La carrera seleccionada debe existir",
					carreraService.findCarreer(c));
		}
	}

	// Getters && Setters

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}

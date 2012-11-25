package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.ExamenService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class InscripcionTest {

	@Autowired
	private InscripcionService inscripcionService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private ExamenService examenService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Test
	public void test() {
		Asignatura asignatura = new Asignatura();
		asignatura.setName("Platilina 101");
		asignatura.setCode("elcodigooo");
		asignatura = asignaturaService.createAsignatura(asignatura);

		Examen examen = new Examen();
		examen.setNota(8);
		examen.setFecha(new Date(System.currentTimeMillis()));
		examen = examenService.createExamen(examen, asignatura);

		Student student = studentService.createStudent(new Student("Chupito",
				"chupame@eltobonia.net", "someCedula", new Date(System
						.currentTimeMillis())));

		Inscripcion inscripcion = inscripcionService.inscripcionAExamen(
				student.getId(), examen.getId());

		assertNotNull("Inscripcion can't be null", inscripcion);
		examen = inscripcion.getExamen();
		asignatura = examen.getAsignatura();
		assertNotNull("Examen can't be null", examen);
		assertNotNull("Asignatura can't be null", asignatura);

	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public ExamenService getExamenService() {
		return examenService;
	}

	public void setExamenService(ExamenService examenService) {
		this.examenService = examenService;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

}

package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean(name = "inscripcionCursoMB")
@SessionScoped
public class InscripcionCursoMB extends GenericMB {

	private static final long serialVersionUID = -826514322630864126L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;

	private List<Carreer> carreras;
	private List<Curso> curso;
	private String ciEst;

	public InscripcionCursoMB() {

	}

	@PostConstruct
	public void init() {
		ciEst = getFromSession("ci_est").toString();
		Student student = studentService.findStudentByCedula(ciEst);

		if (student != null) {
			carreras = inscripcionService.getCarrerasByStudent(student);
		} else {
			sendErrorMessage("Estudiante no encontrado",
					"No se han encontrado el estudiante con la cedula dada");
		}
	}

	public void guardar() {
		return;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

	public List<Carreer> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carreer> carreras) {
		this.carreras = carreras;
	}

	public String getCiEst() {
		return ciEst;
	}

	public void setCiEst(String ciEst) {
		this.ciEst = ciEst;
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

}

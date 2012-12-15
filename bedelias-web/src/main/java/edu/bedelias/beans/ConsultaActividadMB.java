package edu.bedelias.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean(name = "consultaActividadMB")
@SessionScoped
public class ConsultaActividadMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;

	@ManagedProperty(value = "#{evaluacionServiceImpl}")
	private EvaluacionService evaluacionService;

	private List<Curso> cursos;
	private String ciEst;
	private List<Evaluacion> evaluaciones;
	private List<Inscripcion> inscripciones;

	public ConsultaActividadMB() {
		super();
	}

	@PostConstruct
	public void init() {
		if (estaLogueado()) {
			ciEst = getFromSession(this.cedula).toString();
			Student student = studentService.findStudentByCedula(ciEst);
			inscripciones = inscripcionService
					.getInscripcionesByStudent(student);
			cursos = new ArrayList<Curso>();
			for (Inscripcion i : inscripciones) {
				if (i.getTipo().equals(TipoInscripcionEnum.CURSO)) {
					cursos.add(i.getCurso());
				}
			}
			evaluaciones = new ArrayList<Evaluacion>();
			for (Curso c : cursos) {
				Evaluacion e = evaluacionService.getEvaluacionByStudentAndCurso(student, c);
				if (e!= null && e.isNoAsistio() == false) {
					evaluaciones.add(e);
				}
			}
		}
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

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public String getCiEst() {
		return ciEst;
	}

	public void setCiEst(String ciEst) {
		this.ciEst = ciEst;
	}

	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}

	public void setEvaluacionService(EvaluacionService evaluacionService) {
		this.evaluacionService = evaluacionService;
	}

	public List<Evaluacion> getEvaluaciones() {
		return evaluaciones;
	}

	public void setEvaluaciones(List<Evaluacion> evaluaciones) {
		this.evaluaciones = evaluaciones;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}
}

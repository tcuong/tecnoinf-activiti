package edu.bedelias.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean(name = "inscripcionCursoMB")
@SessionScoped
public class InscripcionCursoMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;

	@ManagedProperty(value = "#{cursoServiceImpl}")
	private CursoService cursoService;

	private List<SelectItem> carrerasListItem;
	private List<Carreer> carreras;
	private List<Curso> cursos;
	private String ciEst;
	private String carrera;

	@PostConstruct
	public void init() {
		ciEst = getFromSession("ci_est").toString();
		Student student = studentService.findStudentByCedula(ciEst);

		if (student != null) {
			carreras = inscripcionService.getCarrerasByStudent(student);
			carrerasListItem = new ArrayList<SelectItem>();
			for (Carreer c : carreras) {
				carrerasListItem.add(new SelectItem(c.getId(), c.getName()));
			}
		} else {
			sendErrorMessage("Estudiante no encontrado", "No se han encontrado el estudiante con la cedula dada");
		}
	}

	public void metodo() {
		cursos = cursoService.findAll();
	}
	
	public void inscribirse(String id){
		
		
		
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
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

	public List<SelectItem> getCarrerasListItem() {
		return carrerasListItem;
	}

	public void setCarrerasListItem(List<SelectItem> carrerasListItem) {
		this.carrerasListItem = carrerasListItem;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public String getCarrera() {
		return carrera;
	}

	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

}

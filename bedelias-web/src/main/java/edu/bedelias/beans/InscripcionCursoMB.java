package edu.bedelias.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean(name = "inscripcionCursoMB")
@RequestScoped
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
	private long carreraId;

	public InscripcionCursoMB() {
		super();
	}

	@PostConstruct
	public void init() {
		if (estaLogueado()) {
			
			// primero pregunto si existe un período de inscripcion a cursos abierto
			
			// luego si existe recien le muestro las carreras al estudiante para que se pueda inscribir.
			
			ciEst = getFromSession(this.cedula).toString();
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
	}

	public void actualizarCursos() {
		cursos = cursoService.getCursosByCarrearId(carreraId);
	}

	public void inscribirse(String id) {
		System.out.println("Este es el id del curso = " + id);
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

	public long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(long carreraId) {
		this.carreraId = carreraId;
	}

}

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
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean(name = "DesistirInscripcionMB")
@RequestScoped
public class DesistirInscripcionMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	private List<Inscripcion> inscripcionesCuros;

	public DesistirInscripcionMB() {
		super();
	}

	@PostConstruct
	public void init() {
		String ciEst = getFromSession("ci_est").toString();
		inscripcionesCuros = inscripcionService.getInscripcionesParaDesistir(ciEst);
	}

	public void desistir(String id) {
		System.out.println("El estudiante quire desistir de la incripcion id " + id);
	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public List<Inscripcion> getInscripcionesCuros() {
		return inscripcionesCuros;
	}

	public void setInscripcionesCuros(List<Inscripcion> inscripcionesCuros) {
		this.inscripcionesCuros = inscripcionesCuros;
	}
	
	
}

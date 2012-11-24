package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import edu.bedelias.entities.Inscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.InscripcionService;

@ManagedBean
@SessionScoped
public class VerInscripcionesCursoMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	private List<Inscripcion> inscripciones;
	private String ciEst;

	public VerInscripcionesCursoMB() {
		super();
	}

//	@PostConstruct
	public void init() {
		ciEst = getFromSession("ci_est").toString();
		inscripciones = inscripcionService.getInscripcionesByTipo(ciEst,
				TipoInscripcionEnum.CURSO);
	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public List<Inscripcion> getInscripciones() {
		return inscripciones;
	}

	public void setInscripciones(List<Inscripcion> inscripciones) {
		this.inscripciones = inscripciones;
	}

	public String getCiEst() {
		return ciEst;
	}

	public void setCiEst(String ciEst) {
		this.ciEst = ciEst;
	}
}

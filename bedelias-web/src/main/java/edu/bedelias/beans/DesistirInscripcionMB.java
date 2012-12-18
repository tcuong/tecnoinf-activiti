package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import edu.bedelias.entities.Inscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.InscripcionService;

@ManagedBean(name = "desistirInscripcionMB")
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
		if (estaLogueado()) {
			String ciEst = getFromSession(this.cedula).toString();
			inscripcionesCuros = inscripcionService.getInscripcionesParaDesistir(ciEst);
		}
	}

	public void desistir(Inscripcion inscripcion) {
		inscripcion.setTipo(TipoInscripcionEnum.DESISTIO);
		
		inscripcionService.updateInscripcion(inscripcion);
		
		this.sendInfoMessage("Información", "Su desistimiento ha sido guardado, notificaremos por email cuando sea efectivo. ");
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

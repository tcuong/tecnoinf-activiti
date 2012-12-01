package edu.bedelias.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.services.AsignaturaService;

@ManagedBean(name = "previasMB")
@RequestScoped
public class PreviasMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{asignaturaServiceImpl}")
	private AsignaturaService asignaturaService;

	private long asignaturaId;
	private List<SelectItem> asignaturas;
	private List<Asignatura> previas;

	public PreviasMB() {
		super();
	}

	@PostConstruct
	public void init() {
		asignaturas = new ArrayList<SelectItem>();
		for (Asignatura asig : asignaturaService.findAll()) {
			asignaturas.add(new SelectItem(asig.getId(), asig.getName()));
		}
	}

	public void buscarPrevias() {
		previas = asignaturaService.getPrevias(asignaturaId);
	}

	public void deQuienEsPrevia() {
		previas = asignaturaService.getDeQuienEsPrevia(asignaturaId);
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

	public long getAsignaturaId() {
		return asignaturaId;
	}

	public void setAsignaturaId(long asignaturaId) {
		this.asignaturaId = asignaturaId;
	}

	public List<SelectItem> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<SelectItem> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public List<Asignatura> getPrevias() {
		return previas;
	}

	public void setPrevias(List<Asignatura> previas) {
		this.previas = previas;
	}

}

package edu.bedelias.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import edu.bedelias.entities.generics.GenericEntityName;
import edu.bedelias.enums.AprobacionEnum;

@Entity
public class Asignatura extends GenericEntityName {

	private static final long serialVersionUID = 698397770291392936L;

	private Integer credits;
	private AprobacionEnum tipoAprobacion;
	private Boolean isElectiva;

	@ManyToMany
	@JoinTable(name = "Previas", joinColumns = @JoinColumn(name = "asignatura_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "previa_id", referencedColumnName = "id"))
	private List<Asignatura> previas;

	// Getters && Setters
	public Integer getCredits() {
		return credits;
	}

	public void setCredits(Integer credits) {
		this.credits = credits;
	}

	public AprobacionEnum getTipoAprobacion() {
		return tipoAprobacion;
	}

	public void setTipoAprobacion(AprobacionEnum tipoAprobacion) {
		this.tipoAprobacion = tipoAprobacion;
	}

	public Boolean getIsElectiva() {
		return isElectiva;
	}

	public void setIsElectiva(Boolean isElectiva) {
		this.isElectiva = isElectiva;
	}

	public List<Asignatura> getPrevias() {
		return previas;
	}

	public void setPrevias(List<Asignatura> previas) {
		this.previas = previas;
	}

}

package edu.bedelias.entities;

import javax.persistence.Entity;

import edu.bedelias.entities.generics.GenericEntityName;
import edu.bedelias.enums.AprobacionEnum;

@Entity
public class Asignatura extends GenericEntityName {

	private static final long serialVersionUID = 698397770291392936L;

	private Integer credits;
	private AprobacionEnum tipoAprobacion;
	private Boolean isElectiva;
	
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

}

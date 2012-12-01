/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;

import edu.bedelias.entities.generics.GenericEntity;
import edu.bedelias.enums.TipoInscripcionEnum;

/**
 * @author Administrador
 * 
 */
@Entity
public class PeriodoInscripcion extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Date fechaInicio;
	private Date fechaFin;
	private Date fechaDesist;
	private String descripcion;

	private TipoInscripcionEnum tipoInscripcion;

	private Boolean isHabilitado;

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public TipoInscripcionEnum getTipoInscripcion() {
		return tipoInscripcion;
	}

	public void setTipoInscripcion(TipoInscripcionEnum tipoInscripcion) {
		this.tipoInscripcion = tipoInscripcion;
	}

	public Boolean getIsHabilitado() {
		return isHabilitado;
	}

	public void setIsHabilitado(Boolean isHabilitado) {
		this.isHabilitado = isHabilitado;
	}

	public Date getFechaDesist() {
		return fechaDesist;
	}

	public void setFechaDesist(Date fechaDesist) {
		this.fechaDesist = fechaDesist;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}

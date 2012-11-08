/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;

/**
 * @author Administrador
 *
 */
@Entity
public class Inscripcion extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Date fechaInscripcion;
	private Date fechaDesistir;
	private Boolean isValid;

	public Inscripcion() {
		super();
		this.isValid = false;
	}
	
	// Getters && Setters
	
	public Date getFechaInscripcion() {
		return fechaInscripcion;
	}

	public void setFechaInscripcion(Date fechaInscripcion) {
		this.fechaInscripcion = fechaInscripcion;
	}

	public Date getFechaDesistir() {
		return fechaDesistir;
	}

	public void setFechaDesistir(Date fechaDesistir) {
		this.fechaDesistir = fechaDesistir;
	}

	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}
	
}

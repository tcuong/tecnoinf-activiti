package edu.bedelias.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;

@Entity
public class SolicitudAsignatura extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nombreDocente;

	@Column(nullable = false)
	private String cedulaDocente;

	@Column(nullable = false)
	private String nombreAsignatura;

	@Column(nullable = false)
	private String propuesta;

	@ManyToOne
	@JoinColumn(name = "materia")
	private Materia materia;

	public SolicitudAsignatura() {
		super();
	}

	public String getNombreDocente() {
		return nombreDocente;
	}

	public void setNombreDocente(String nombreDocente) {
		this.nombreDocente = nombreDocente;
	}

	public String getCedulaDocente() {
		return cedulaDocente;
	}

	public void setCedulaDocente(String cedulaDocente) {
		this.cedulaDocente = cedulaDocente;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public void setNombreAsignatura(String nombreAsignatura) {
		this.nombreAsignatura = nombreAsignatura;
	}

	public String getPropuesta() {
		return propuesta;
	}

	public void setPropuesta(String propuesta) {
		this.propuesta = propuesta;
	}

	public Materia getMateria() {
		return materia;
	}

	public void setMateria(Materia materia) {
		this.materia = materia;
	}

}

package edu.bedelias.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;

@Entity
public class Minuta extends GenericEntity {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String resolucion;

	@Column(nullable = false)
	private String nombreFuncionario;

	@Column(nullable = false)
	private String nombreEntidad;

	@Column(nullable = false)
	private boolean aprobado;

	@ManyToOne
	@JoinColumn(name = "solicitud")
	private SolicitudAsignatura solicitudAsignatura;

	public Minuta() {
		super();
	}

	public String getResolucion() {
		return resolucion;
	}

	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	public String getNombreFuncionario() {
		return nombreFuncionario;
	}

	public void setNombreFuncionario(String nombreFuncionario) {
		this.nombreFuncionario = nombreFuncionario;
	}

	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

	public boolean isAprobado() {
		return aprobado;
	}

	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}

	public SolicitudAsignatura getSolicitudAsignatura() {
		return solicitudAsignatura;
	}

	public void setSolicitudAsignatura(SolicitudAsignatura solicitudAsignatura) {
		this.solicitudAsignatura = solicitudAsignatura;
	}

}

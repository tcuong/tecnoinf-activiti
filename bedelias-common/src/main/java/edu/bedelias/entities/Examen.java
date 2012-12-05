package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;

@Entity
public class Examen extends GenericEntity {

	private static final long serialVersionUID = -2023907175216649506L;

	private String periodo;

	private Date fecha;

	@ManyToOne
	@JoinColumn(name = "asignatura")
	private Asignatura asignatura;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

}

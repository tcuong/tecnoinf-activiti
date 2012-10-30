package edu.bedelias.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

import edu.bedelias.enums.TurnoEnum;

@Entity
public class Curso extends GenericEntityName implements Serializable{

	private static final long serialVersionUID = 7343061410125816324L;
	
	private String descripcion;
	
	private String semestre;
	
	private String horario;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private TurnoEnum turno;
	
	private String salon;
	
	private Integer nota;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

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

	public TurnoEnum getTurno() {
		return turno;
	}

	public void setTurno(TurnoEnum turno) {
		this.turno = turno;
	}

	public String getSalon() {
		return salon;
	}

	public void setSalon(String salon) {
		this.salon = salon;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}
	
	

}

package edu.bedelias.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Examen extends GenericEntity implements Serializable{

	private static final long serialVersionUID = -2023907175216649506L;
	
	private Integer nota;
	
	private String periodo;
	
	private Date fecha;
	
	private Boolean noAsistio;

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

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

	public Boolean getNoAsistio() {
		return noAsistio;
	}

	public void setNoAsistio(Boolean noAsistio) {
		this.noAsistio = noAsistio;
	}

}

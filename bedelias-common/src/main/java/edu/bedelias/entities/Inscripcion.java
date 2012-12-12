/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;
import edu.bedelias.enums.TipoInscripcionEnum;

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
	private TipoInscripcionEnum tipo;

	@ManyToOne
	@JoinColumn(name = "estudiante")
	private Student estudiante;

	@ManyToOne
	@JoinColumn(name = "carrera")
	private Carreer carrera;

	@ManyToOne
	@JoinColumn(name = "curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "examen")
	private Examen examen;

	@ManyToOne
	@JoinColumn(name = "periodo")
	private PeriodoInscripcion periodo;

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

	public Student getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}

	public Carreer getCarrera() {
		return carrera;
	}

	public void setCarrera(Carreer carrera) {
		this.carrera = carrera;
	}

	public TipoInscripcionEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoInscripcionEnum tipo) {
		this.tipo = tipo;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public PeriodoInscripcion getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoInscripcion periodo) {
		this.periodo = periodo;
	}
	
}

/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;
import edu.bedelias.enums.TipoEvaluacionEnum;

/**
 * @author Administrador
 * 
 */
@Entity
public class Evaluacion extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Date fechaEvaluacion;
	private Integer resultado;
	private TipoEvaluacionEnum tipoEvaluacion;
	private Integer nota;

	@ManyToOne
	@JoinColumn(name = "curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "estudiante")
	private Student estudiante;

	public Evaluacion() {
		super();
	}

	public Evaluacion(Integer resultado, Date fechaEvaluacion,
			TipoEvaluacionEnum tipo) {
		super();
		this.resultado = resultado;
		this.fechaEvaluacion = fechaEvaluacion;
		this.tipoEvaluacion = tipo;
	}

	// Getters && Setters

	public Date getFechaEvaluacion() {
		return fechaEvaluacion;
	}

	public void setFechaEvaluacion(Date fechaEvaluacion) {
		this.fechaEvaluacion = fechaEvaluacion;
	}

	public Integer getResultado() {
		return resultado;
	}

	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}

	public TipoEvaluacionEnum getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(TipoEvaluacionEnum tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

	public Student getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Student estudiante) {
		this.estudiante = estudiante;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

}

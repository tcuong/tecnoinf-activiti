/**
 * 
 */
package edu.bedelias.entities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import edu.bedelias.entities.generics.GenericEntity;
import edu.bedelias.enums.EstadoAprobacionEnum;
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
	private boolean noAsistio;
	private EstadoAprobacionEnum estado;

	@ManyToOne
	@JoinColumn(name = "curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name = "examen")
	private Examen examen;

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

	public boolean isNoAsistio() {
		return noAsistio;
	}

	public void setNoAsistio(boolean noAsistio) {
		this.noAsistio = noAsistio;
	}

	public EstadoAprobacionEnum getEstado() {
		return estado;
	}

	public void setEstado(EstadoAprobacionEnum estado) {
		this.estado = estado;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
	
	public String getFechaEvaluacionForPage(){
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/YYYY");
		return format.format(fechaEvaluacion);
	}

}

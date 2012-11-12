/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

	@ManyToOne
	@JoinColumn(name = "estudiante")
	private Student estudiante;

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

}

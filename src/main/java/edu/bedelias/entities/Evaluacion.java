/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Entity;

import edu.bedelias.enums.EvaluacionTipoEnum;

/**
 * @author Administrador
 *
 */
@Entity
public class Evaluacion extends GenericEntity {

	private static final long serialVersionUID = 1L;

	private Date fechaEvaluacion;
	private Integer resultado;
	
	private EvaluacionTipoEnum tipoEvaluacion;

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

	public EvaluacionTipoEnum getTipoEvaluacion() {
		return tipoEvaluacion;
	}

	public void setTipoEvaluacion(EvaluacionTipoEnum tipoEvaluacion) {
		this.tipoEvaluacion = tipoEvaluacion;
	}

}

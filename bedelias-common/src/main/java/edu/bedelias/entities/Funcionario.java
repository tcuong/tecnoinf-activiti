/**
 * 
 */
package edu.bedelias.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import edu.bedelias.enums.TipoFuncionarioEnum;

/**
 * @author Administrador
 * 
 */
@Entity
public class Funcionario extends Person {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numeroFuncionario;

	private TipoFuncionarioEnum tipoFuncionario;

	// @ManyToOne
	// @JoinColumn(name = "INSTITUTO_ID")
	// private Instituto instituto;
	//
	// // Getters && Setters
	//
	// public Instituto getInstituto() {
	// return instituto;
	// }
	//
	// public void setInstituto(Instituto instituto) {
	// this.instituto = instituto;
	// }

	public Long getNumeroFuncionario() {
		return numeroFuncionario;
	}

	public void setNumeroFuncionario(Long numeroFuncionario) {
		this.numeroFuncionario = numeroFuncionario;
	}

	public TipoFuncionarioEnum getTipoFuncionario() {
		return tipoFuncionario;
	}

	public void setTipoFuncionario(TipoFuncionarioEnum tipoFuncionario) {
		this.tipoFuncionario = tipoFuncionario;
	}

}

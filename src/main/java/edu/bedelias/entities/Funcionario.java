/**
 * 
 */
package edu.bedelias.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import edu.bedelias.enums.TipoFuncionarioEnum;

/**
 * @author Administrador
 *
 */
public class Funcionario extends Person {
	
	private static final long serialVersionUID = 1L;
	
	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long numeroFuncionario;
	
	private TipoFuncionarioEnum tipoFuncionario;

	// Getters && Setters
	
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

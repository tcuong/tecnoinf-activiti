/**
 * 
 */
package edu.bedelias.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * @author Administrador
 * 
 */
@Entity
public class Instituto extends GenericEntityName {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "instituto")
	private List<Funcionario> funcionarios;

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}

}

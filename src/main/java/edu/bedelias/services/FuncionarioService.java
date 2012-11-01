package edu.bedelias.services;

import edu.bedelias.entities.Funcionario;

public interface FuncionarioService {

	public Funcionario createFuncionario(Funcionario funcionario);
	
	public void updateFuncionario(Funcionario funcionario);
	
	public void deleteFuncionario(Funcionario funcionario);
}

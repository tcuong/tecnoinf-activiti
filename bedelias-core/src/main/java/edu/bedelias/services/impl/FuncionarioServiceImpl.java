package edu.bedelias.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Funcionario;
import edu.bedelias.repositories.FuncionarioRepository;
import edu.bedelias.services.FuncionarioService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class FuncionarioServiceImpl implements FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepo;

	@Override
	@Transactional
	public Funcionario createFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			funcionario = funcionarioRepo.save(funcionario);
		}
		return funcionario;
	}

	@Override
	@Transactional
	public void updateFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			funcionario = funcionarioRepo.save(funcionario);
		}
	}

	@Override
	@Transactional
	public void deleteFuncionario(Funcionario funcionario) {
		funcionarioRepo.delete(funcionario);

	}

	// Getters && Setters

	public FuncionarioRepository getFuncionarioRepo() {
		return funcionarioRepo;
	}

	public void setFuncionarioRepo(FuncionarioRepository funcionarioRepo) {
		this.funcionarioRepo = funcionarioRepo;
	}

}

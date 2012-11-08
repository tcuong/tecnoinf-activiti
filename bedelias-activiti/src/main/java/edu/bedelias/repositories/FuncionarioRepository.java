package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Funcionario;
import edu.bedelias.enums.TipoFuncionarioEnum;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */
	
	public Funcionario findFuncionarioByNumeroFuncionario(Long numeroFuncionario);
	
	public List<Funcionario> findFuncionarioByTipoFuncionario(TipoFuncionarioEnum tipoFuncionario);

}

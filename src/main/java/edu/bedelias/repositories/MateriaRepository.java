package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long>{
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

}

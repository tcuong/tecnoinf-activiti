package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Instituto;

public interface InstitutoRepository extends JpaRepository<Instituto, Long>{

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

}

package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodoInscripcionRepository extends JpaRepository<PeriodoInscripcionRepository, Long>{
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */


}

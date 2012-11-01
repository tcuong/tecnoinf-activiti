package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.PeriodoInscripcion;

public interface PeriodoInscripcionRepository extends
		JpaRepository<PeriodoInscripcion, Long> {
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */


}

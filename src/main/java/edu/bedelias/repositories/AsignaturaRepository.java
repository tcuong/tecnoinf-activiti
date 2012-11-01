package edu.bedelias.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long>{
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	public Asignatura findAsignaturaByCode(UUID code);
}

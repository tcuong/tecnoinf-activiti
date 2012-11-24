package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	public Asignatura findByUuid(String uuid);

	// @Query() //Encajar la query aca!
	// public List<Asignatura> getPrevias(Long id);
}

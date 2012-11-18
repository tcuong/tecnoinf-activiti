package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Carreer;

public interface CarreerRepository extends JpaRepository<Carreer, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	// @Query("select c from Carreer c left join fetch Materia m where m.carreer_id = ?1")
	// public List<Materia> getMateriasByCarreerId(Long id);
}

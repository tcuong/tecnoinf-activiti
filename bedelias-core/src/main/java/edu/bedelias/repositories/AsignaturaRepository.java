package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	public Asignatura findByUuid(String uuid);

	@Query("select previas from Asignatura a inner join a.previas as previas where a.id = ?1")
	public List<Asignatura> getPrevias(Long id);

	@Query("select a from Asignatura a inner join a.previas as previas where previas = ?1")
	public List<Asignatura> getDeQuienEsPrevi(Asignatura asignatura);
}

package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */
	@Query("select asignaturas from Materia m inner join m.asignaturas as asignaturas where m.id= ?1")
	public List<Asignatura> getAsignaturasByMateriaId(Long id);

}

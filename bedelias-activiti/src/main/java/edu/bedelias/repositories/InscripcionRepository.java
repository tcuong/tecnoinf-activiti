package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

	@Query("select i from Inscripcion i where i.estudiante = ?1")
	public List<Inscripcion> getInscripcionesBySrudent(Student student);

	@Query("select i from Inscripcion i where i.estudiante = ?1 and i.tipo = ?2")
	public List<Inscripcion> getInscripcionesByTipo(Student student,
			TipoInscripcionEnum tipoIns);

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

}

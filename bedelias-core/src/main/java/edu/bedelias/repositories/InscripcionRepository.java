package edu.bedelias.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	public List<Inscripcion> findInscripcionByEstudianteAndTipo(
			Student estudiante, TipoInscripcionEnum tipo);

	// FIXME probar hacerlo con un findBy
	@Query("select i from Inscripcion i where i.estudiante = ?1 and i.tipo = ?2")
	public List<Inscripcion> getInscripcionesByTipo(Student student,
			TipoInscripcionEnum tipoIns);

	public List<Inscripcion> findInscripcionByEstudiante(Student estudiante);

	@Query("select i from Inscripcion i where i.curso = ?1")
	public List<Inscripcion> findInscripcionesByCursoId(Curso curso);

	@Query("select i from Inscripcion i where i.examen = ?1")
	public List<Inscripcion> findInscripcionesByExamen(Examen examen);
	
	@Query("select i from Inscripcion i where i.isValid = ?1 and i.tipo = ?2 and i.fechaInscripcion >= ?3")
	public List<Inscripcion> fetchInscripcionesByIsValidAndTipo(boolean isValid, TipoInscripcionEnum tipo, Date fechaInscripcion);
}

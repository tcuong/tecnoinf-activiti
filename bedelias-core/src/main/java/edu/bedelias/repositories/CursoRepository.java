package edu.bedelias.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	public List<Curso> findCursoBySemestre(String semestre);

	public Curso findCursoByUuid(String uuid);

	public List<Curso> findCursoByTurno(String turno);

	public List<Curso> findCursoBySalon(String salon);

	public List<Curso> findCursoByFechaInicio(Date fechaInicio);

	public List<Curso> findCursoByFechaFin(Date fechaFin);

	public Curso findCursoById(Long id);

}

package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	@Query("select e from Evaluacion e where e.estudiante = ?1")
	public List<Evaluacion> getEvaluacionesByStudentId(Student student);

	@Query("select e from Evaluacion e where e.estudiante = ?1 and e.curso = ?2")
	public Evaluacion getEvaluacionByStudentAndCurso(Student student,
			Curso curso);

	@Query("select e from Evaluacion e where e.curso = ?1")
	public List<Evaluacion> getEvaluacionesByCurso(Curso curso);

}

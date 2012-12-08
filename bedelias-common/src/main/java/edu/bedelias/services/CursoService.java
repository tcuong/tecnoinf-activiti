package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Student;

public interface CursoService {

	public Curso createCurso(Curso curso, Asignatura asignatura);

	public void updateCurso(Curso curso);

	public void deleteCurso(Curso curso);

	public Curso findCursoById(Long id);

	public boolean existeCursoByCodigo(String codigoCurso);

	public void generarActa(String codigoCurso);

	public List<Curso> findAll();

	public List<Curso> getCursosByCarrearId(Long id);

	/**
	 * Este metodo retorna los inscriptos a un curso a partir de el id de ese
	 * curso, y solo retorna los estudiantes con inscripcion valida.
	 * 
	 * @param cursoId
	 * @return
	 */
	public List<Student> getEstudiantesInsciptosACurso(Curso curso);
	
	public List<Student> getEstudiantesInsciptosACurso(String cursoId);

}

package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;

public interface CursoService {

	public Curso createCurso(Curso curso, Asignatura asignatura);

	public void updateCurso(Curso curso);

	public void deleteCurso(Curso curso);

	public Curso findCursoById(Long id);

	public boolean existeCursoByCodigo(String codigoCurso);

	public void generarActa(String codigoCurso);

	public List<Curso> findAll();
	
	public List<Curso> getCursosByCarrera(String carreraId);

	public List<Curso> getCursosByCarrearId(Long id);

}

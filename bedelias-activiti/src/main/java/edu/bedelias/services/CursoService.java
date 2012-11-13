package edu.bedelias.services;

import edu.bedelias.entities.Curso;

public interface CursoService {

	public Curso createCurso(Curso curso);

	public void updateCurso(Curso curso);

	public void deleteCurso(Curso curso);

	public Curso findCursoById(Long id);

	boolean ExisteCursoByCodigo(String codigoCurso);

	void GenerarActa(String codigoCurso);
}

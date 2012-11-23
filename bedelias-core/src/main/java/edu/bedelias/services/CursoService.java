package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Curso;

public interface CursoService {

	public Curso createCurso(Curso curso);

	public void updateCurso(Curso curso);

	public void deleteCurso(Curso curso);

	public Curso findCursoById(Long id);

	public boolean existeCursoByCodigo(String codigoCurso);

	public void generarActa(String codigoCurso);

	public List<Curso> findAll();
}
package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;

public interface EvaluacionService {

	public Evaluacion createEvaluacion(Evaluacion evaluacion);
	
	public void createEvaluacion(List<Evaluacion> evaluaciones);

	public void updateEvaluacion(Evaluacion evaluacion);

	public void deleteEvaluacion(Evaluacion evaluacion);

	public List<Evaluacion> getEvaluacionesByStudentId(Student student);

	public Evaluacion getEvaluacionByStudentAndCurso(Student student, Curso curso);
	
	public Evaluacion getEvaluacionByStudentAndCurso(Student student, String cursoId);
	
	public List<Evaluacion> getEvaluacionesByCurso(Long cursoId);

	public Evaluacion createEvaluacion(Evaluacion evaluacion, Long studentId, Long cursoId);

}
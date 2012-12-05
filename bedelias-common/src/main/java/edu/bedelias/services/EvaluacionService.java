package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;

public interface EvaluacionService {

	public Evaluacion createEvaluacion(Evaluacion evaluacion);

	public void updateEvaluacion(Evaluacion evaluacion);

	public void deleteEvaluacion(Evaluacion evaluacion);

	public List<Evaluacion> getEvaluacionesByStudentId(Student student);

	public Evaluacion getEvaluacionByStudentAndCurso(Student student,
			Curso curso);

	public Evaluacion createEvaluacion(Evaluacion evaluacion, Long studentId,
			Long cursoId);
	// TODO ver aca si nos sirve tener un metodo de crearEvaluacion(Curso
	// curso),
	// crearEvaluacion(Student student), o de hacer un updateEvaluacion(Curso
	// curso) o con el estudiante
	// por si interesa crearla sin nada y despues asociarle el estudiante o el
	// curso...

}
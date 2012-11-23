package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;

public interface EvaluacionService {

	public Evaluacion createEvaluacion(Evaluacion evaluacion);

	public void updateEvaluacion(Evaluacion evaluacion);

	public void deleteEvaluacion(Evaluacion evaluacion);

	public List<Evaluacion> getEvaluacionesByStudentId(Student student);

	public Evaluacion createEvaluacion(Evaluacion evaluacion, Long studentId);

}
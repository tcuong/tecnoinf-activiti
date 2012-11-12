package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;

public interface EvaluacionService {

	public Evaluacion createEvaluacion(Evaluacion evaluacion);

	public void updateEvaluacio(Evaluacion evaluacion);

	public void deleteEvaluacion(Evaluacion evaluacion);

	public List<Evaluacion> getEvaluacionesByStudentId(Student student);

}
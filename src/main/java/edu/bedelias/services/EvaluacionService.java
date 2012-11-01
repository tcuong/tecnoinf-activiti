package edu.bedelias.services;

import edu.bedelias.entities.Evaluacion;

public interface EvaluacionService {
	
	public Evaluacion createEvaluacion(Evaluacion evaluacion);
	
	public void updateEvaluacio(Evaluacion evaluacion);
	
	public void deleteEvaluacion(Evaluacion evaluacion);

}
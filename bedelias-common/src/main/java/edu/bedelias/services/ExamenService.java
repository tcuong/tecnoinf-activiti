package edu.bedelias.services;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Examen;

public interface ExamenService {

	public Examen createExamen(Examen examen, Asignatura asignatura);

	public void updateExamen(Examen examen);

	public void deleteExamen(Examen examen);

}

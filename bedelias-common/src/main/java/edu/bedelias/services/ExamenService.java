package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Student;

public interface ExamenService {

	public Examen createExamen(Examen examen, Asignatura asignatura);

	public void updateExamen(Examen examen);

	public void deleteExamen(Examen examen);

	public Boolean existeExamenByCodigo(String codigoExamen);

	public void generarActa(String codigoExamen);

	public List<Student> getEstudiantesInsciptosAExamen(Examen examen);

}

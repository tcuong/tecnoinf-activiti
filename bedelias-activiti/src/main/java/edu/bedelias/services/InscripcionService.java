package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface InscripcionService {

	public Inscripcion createInscripcion(Inscripcion inscripcion);

	public void updateInscripcion(Inscripcion inscripcion);

	public void deleteInscripcion(Inscripcion inscripcion);

	public List<Inscripcion> getInscripcionesByStudent(Student student);

	public List<Inscripcion> getInscripcionesByTipo(Student student,
			TipoInscripcionEnum tipo);

	public List<Carreer> getCarrerasByStudent(Student student);

	public List<Curso> getCursoByStudent(Student student);

}

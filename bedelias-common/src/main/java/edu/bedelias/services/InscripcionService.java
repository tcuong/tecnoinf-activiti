package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface InscripcionService {

	public Inscripcion createInscripcion(Inscripcion inscripcion);

	public String createInscripcion_Activiti(long idCarrera, String cedula);

	public void updateInscripcion(Inscripcion inscripcion);

	public void deleteInscripcion(Inscripcion inscripcion);

	public List<Inscripcion> getInscripcionesByStudent(Student student);

	public List<Inscripcion> getInscripcionesByTipo(String ciEst, TipoInscripcionEnum tipo);

	public List<Carreer> getCarrerasByStudent(Student student);

	public List<Curso> getCursoByStudent(Student student);

	public Inscripcion InscripcionACarrera(Long studentId, Long carreerId, Long periodoId);

	public Inscripcion InscripcionACurso(Long studentId, Long cursoId, Long periodoId);

	public Inscripcion inscripcionAExamen(Long studentId, Long examenId, Long periodoId);

	public List<Inscripcion> getInscripcionesParaDesistir(String ciEst);

	public List<Inscripcion> findInscripcionesByCursoId(Curso curso);

	public Inscripcion getInscripcionByStudentYCurso(Student student, Curso curso);
	
	public Inscripcion getDesistimientoByStudentYCurso(Student student, Curso curso);

}

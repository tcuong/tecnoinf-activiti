package edu.bedelias.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.repositories.InscripcionRepository;
import edu.bedelias.services.CursoService;
import edu.bedelias.utils.ReportsService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepo;

	@Autowired
	private InscripcionRepository inscripcionRepo;

	private Logger logger = Logger.getLogger(CursoServiceImpl.class);

	public CursoServiceImpl() {
	}

	@Override
	@Transactional
	public Curso createCurso(Curso curso, Asignatura asignatura) {
		if (curso != null) {
			curso.setAsignatura(asignatura);
			curso = cursoRepo.save(curso);
		}
		return curso;
	}

	@Override
	@Transactional
	public void updateCurso(Curso curso) {
		if (curso != null) {
			curso = cursoRepo.save(curso);
		}
	}

	@Override
	@Transactional
	public void deleteCurso(Curso curso) {
		cursoRepo.delete(curso);
	}

	@Override
	public Curso findCursoById(Long id) {
		return cursoRepo.findCursoById(id);
	}

	@Override
	public boolean existeCursoByCodigo(String codigoCurso) {

		if (codigoCurso != null) {
			if (cursoRepo.findCursoByUuid(codigoCurso) != null) {
				return Boolean.TRUE;
			}
		}

		return Boolean.FALSE;
	}

	@Override
	public void generarActa(String codigoCurso) {
		logger.info("generarActa, codigoCurso = " + codigoCurso);
		Curso curso = cursoRepo.findCursoByUuid(codigoCurso);
		List<Student> estudiantes = this.getEstudiantesInsciptosACurso(curso);
		ReportsService.print(estudiantes, curso);
	}

	@Override
	public List<Curso> findAll() {
		return cursoRepo.findAll();

	}

	@Override
	public List<Student> getEstudiantesInsciptosACurso(Curso curso) {
		List<Inscripcion> inscripciones = inscripcionRepo
				.findInscripcionesByCursoId(curso);
		List<Student> estudiantes = new ArrayList<Student>();
		for (Inscripcion i : inscripciones) {
			if (i.getIsValid()) {
				estudiantes.add(i.getEstudiante());
			}
		}
		return estudiantes;
	}

	@Override
	public List<Curso> getCursosByCarrearId(Long id) {
		return cursoRepo.getCursosByCarreraId(id);
	}

	// Getters && Setters

	public CursoRepository getCursoRepo() {
		return cursoRepo;
	}

	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}

	public InscripcionRepository getInscripcionRepo() {
		return inscripcionRepo;
	}

	public void setInscripcionRepo(InscripcionRepository inscripcionRepo) {
		this.inscripcionRepo = inscripcionRepo;
	}

}

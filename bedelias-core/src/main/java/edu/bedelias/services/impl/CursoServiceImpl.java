package edu.bedelias.services.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.services.CursoService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepo;

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
		// if (codigoCurso != null) {
		// if (cursoRepo.findCursoByUuid(codigoCurso) != null) {
		// return Boolean.TRUE;
		// }
		// }

		logger.info("existeCodigoByCurso, codigoCurso = " + codigoCurso);
		if (codigoCurso.equals("TETE")) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public void generarActa(String codigoCurso) {
		logger.info("generarActa, codigoCurso = " + codigoCurso);
	}

	@Override
	public List<Curso> findAll() {
		return cursoRepo.findAll();

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

	public List<Curso> getCursosByCarrera(String carreraId) {
		// este método esta sin implementar
		// return this.cursoRepo.findCursoByCarrera(carreraId);
		return null;
	}

}

package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Curso;
import edu.bedelias.repositories.CursoRepository;

@Service
@Transactional(readOnly = true)
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepo;
	
	@Override
	@Transactional
	public Curso createCurso(Curso curso) {
		if (curso != null) {
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

	// Getters && Setters
	
	public CursoRepository getCursoRepo() {
		return cursoRepo;
	}

	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}
	
}

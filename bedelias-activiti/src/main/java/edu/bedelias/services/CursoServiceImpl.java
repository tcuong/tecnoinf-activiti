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

	@Override
	public Curso findCursoById(Long id) {
		return cursoRepo.findCursoById(id);
	}

	@Override
	public boolean ExisteCursoByCodigo(String codigoCurso) {
		if (codigoCurso != null) {
			if (cursoRepo.findCursoByUuid(codigoCurso) != null) {
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
	}
	
	@Override
	public void GenerarActa(String codigoCurso) {
		
		
		return;
	}

	// Getters && Setters

	public CursoRepository getCursoRepo() {
		return cursoRepo;
	}

	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}

}

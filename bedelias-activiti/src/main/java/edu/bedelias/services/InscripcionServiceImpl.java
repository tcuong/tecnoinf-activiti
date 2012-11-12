package edu.bedelias.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.repositories.CarreerRepository;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.repositories.InscripcionRepository;

@Service
@Transactional(readOnly = true)
public class InscripcionServiceImpl implements InscripcionService {

	@Autowired
	private InscripcionRepository inscripcionRepo;

	@Autowired
	private CarreerRepository carreerRepo;

	@Autowired
	private CursoRepository cursoRepo;

	@Override
	@Transactional
	public Inscripcion createInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
		return inscripcion;

	}

	@Override
	@Transactional
	public void updateInscripcion(Inscripcion inscripcion) {
		if (inscripcion != null) {
			inscripcion = inscripcionRepo.save(inscripcion);
		}
	}

	@Override
	@Transactional
	public void deleteInscripcion(Inscripcion inscripcion) {
		inscripcionRepo.delete(inscripcion);
	}
	
	// Getters && Setters
	
	public InscripcionRepository getInscripcionRepo() {
		return inscripcionRepo;
	}

	@Override
	public List<Inscripcion> getInscripcionesByStudent(Student student) {
		return inscripcionRepo.getInscripcionesBySrudent(student);
	}

	@Override
	public List<Carreer> getCarrerasByStudent(Student student) {
		List<Inscripcion> inscripciones = this
				.getInscripcionesByStudent(student);
		List<Carreer> carreers = new ArrayList<Carreer>();
		for (Inscripcion ins : inscripciones) {
			if (ins.getTipo() == TipoInscripcionEnum.CARRERA) {
				carreers.add(carreerRepo.findOne(ins.getCarrera().getId()));
			}
		}
		return carreers;
	}

	@Override
	public List<Curso> getCursoByStudent(Student student) {

		List<Inscripcion> inscripciones = this
				.getInscripcionesByStudent(student);
		List<Curso> cursos = new ArrayList<Curso>();
		for (Inscripcion ins : inscripciones) {
			if (ins.getTipo() == TipoInscripcionEnum.CURSO) {
				cursos.add(cursoRepo.findOne(ins.getCurso().getId()));
			}
		}
		return cursos;
	}

	@Override
	public List<Inscripcion> getInscripcionesByStudent(Student student) {
		return inscripcionRepo.getInscripcionesBySrudent(student);
	}

	@Override
	public List<Inscripcion> getInscripcionesByTipo(Student student,
			TipoInscripcionEnum tipo) {
		return inscripcionRepo.getInscripcionesByTipo(student, tipo);
	}
	public void setInscripcionRepo(InscripcionRepository inscripcionRepo) {
		this.inscripcionRepo = inscripcionRepo;
	}

}

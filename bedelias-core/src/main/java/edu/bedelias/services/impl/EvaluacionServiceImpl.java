package edu.bedelias.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.AprobacionEnum;
import edu.bedelias.enums.EstadoAprobacionEnum;
import edu.bedelias.repositories.CursoRepository;
import edu.bedelias.repositories.EvaluacionRepository;
import edu.bedelias.repositories.StudentRepository;
import edu.bedelias.services.EvaluacionService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionRepository evaluacionRepo;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private CursoRepository cursoRepo;

	// Getters && Setters

	public EvaluacionRepository getEvaluacionRepo() {
		return evaluacionRepo;
	}

	public void setEvaluacionRepo(EvaluacionRepository evaluacionRepo) {
		this.evaluacionRepo = evaluacionRepo;
	}

	public StudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	@Transactional
	public Evaluacion createEvaluacion(Evaluacion evaluacion) {
		if (evaluacion != null) {
			evaluacion = evaluacionRepo.save(evaluacion);
		}
		return evaluacion;
	}

	@Override
	public void createEvaluacion(List<Evaluacion> evaluaciones) {
		// TODO si alguien sabe como hacerlo batch mejor ahora va a lo guerrero
		for (Evaluacion evaluacion : evaluaciones) {
			evaluacionRepo.save(evaluacion);
		}
	}

	@Override
	@Transactional
	public void updateEvaluacion(Evaluacion evaluacion) {
		if (evaluacion != null) {
			evaluacion = evaluacionRepo.save(evaluacion);
		}
	}

	@Override
	@Transactional
	public void deleteEvaluacion(Evaluacion evaluacion) {
		evaluacionRepo.delete(evaluacion);
	}

	@Override
	public Evaluacion getEvaluacionByStudentAndCurso(Student student,
			Curso curso) {
		return evaluacionRepo.getEvaluacionByStudentAndCurso(student, curso);
	}

	@Override
	public Evaluacion getEvaluacionByStudentAndCurso(Student student,
			String cursoId) {
		Curso curso = cursoRepo.findOne(Long.valueOf(cursoId));
		return evaluacionRepo.getEvaluacionByStudentAndCurso(student, curso);
	}

	@Override
	@Transactional
	public List<Evaluacion> getEvaluacionesByStudentId(Student student) {
		try {
			return evaluacionRepo.getEvaluacionesByStudentId(student);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Evaluacion createEvaluacion(Evaluacion evaluacion, Long studentId,
			Long cursoId) {
		try {
			Student estudiante = studentRepo.findOne(studentId);
			Curso curso = cursoRepo.findOne(cursoId);

			if (estudiante != null && curso != null) {
				evaluacion.setCurso(curso);
				evaluacion.setEstudiante(estudiante);
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return evaluacionRepo.save(evaluacion);
	}

	@Override
	public List<Evaluacion> getEvaluacionesAprobadasByStudentAndCurso(
			Long studentId) {
		Student student = studentRepo.findOne(studentId);
		List<Evaluacion> evaluaciones = evaluacionRepo
				.getEvaluacionesByStudentId(student);
		for (Evaluacion eval : evaluaciones) {
			if (eval.getExamen() != null) {
				evaluaciones.remove(eval);
			}
		}
		for (Evaluacion e : evaluaciones) {
			if (e.getCurso() != null) {
				if (!e.getCurso().getAsignatura().getTipoAprobacion()
						.equals(AprobacionEnum.CURSO)
						|| e.getEstado()
								.equals(EstadoAprobacionEnum.NOAPROBADO)) {
					evaluaciones.remove(e);
				}
			}
		}
		return evaluaciones;
	}

	@Override
	public List<Evaluacion> getEvaluacionesAprobadasByStudentAndExamen(
			Long studentId) {
		Student student = studentRepo.findOne(studentId);
		List<Evaluacion> evaluaciones = evaluacionRepo
				.getEvaluacionesByStudentId(student);
		for (Evaluacion eval : evaluaciones) {
			if (eval.getCurso() != null) {
				evaluaciones.remove(eval);
			}
		}
		for (Evaluacion e : evaluaciones) {
			if (e.getExamen() != null) {
				if (!e.getExamen().getAsignatura().getTipoAprobacion()
						.equals(AprobacionEnum.EXAMEN)
						|| e.getEstado()
								.equals(EstadoAprobacionEnum.NOAPROBADO)) {
					evaluaciones.remove(e);
				}
			}
		}
		return evaluaciones;
	}

	public CursoRepository getCursoRepo() {
		return cursoRepo;
	}

	public void setCursoRepo(CursoRepository cursoRepo) {
		this.cursoRepo = cursoRepo;
	}

	@Override
	public List<Evaluacion> getEvaluacionesByCurso(Long cursoId) {
		Curso curso = cursoRepo.findOne(cursoId);
		return evaluacionRepo.getEvaluacionesByCurso(curso);
	}

}

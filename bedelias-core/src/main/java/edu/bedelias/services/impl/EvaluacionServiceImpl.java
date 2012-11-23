package edu.bedelias.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
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
	public Evaluacion createEvaluacion(Evaluacion evaluacion, Long studentId) {
		try {
			Student estudiante = studentRepo.findOne(studentId);

			if (estudiante != null) {
				evaluacion.setEstudiante(estudiante);
				return evaluacionRepo.save(evaluacion);
			}
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}
}

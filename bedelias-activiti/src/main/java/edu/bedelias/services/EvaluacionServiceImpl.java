package edu.bedelias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.repositories.EvaluacionRepository;

@Service
@Transactional(readOnly = true)
public class EvaluacionServiceImpl implements EvaluacionService {

	@Autowired
	private EvaluacionRepository evaluacionRepo;

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
	public void updateEvaluacio(Evaluacion evaluacion) {
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
		return evaluacionRepo.getEvaluacionesByStudentId(student);
	}

}

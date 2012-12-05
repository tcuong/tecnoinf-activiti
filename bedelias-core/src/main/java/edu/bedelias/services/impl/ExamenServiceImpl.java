package edu.bedelias.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Examen;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.repositories.ExamenRepository;
import edu.bedelias.repositories.InscripcionRepository;
import edu.bedelias.services.ExamenService;
import edu.bedelias.utils.ReportsService;

@Service
@Scope(value = "session")
@Transactional(readOnly = true)
public class ExamenServiceImpl implements ExamenService {

	@Autowired
	private ExamenRepository examenRepo;

	@Autowired
	private InscripcionRepository inscripcionRepo;

	@Override
	@Transactional
	public Examen createExamen(Examen examen, Asignatura asignatura) {
		if (examen != null && asignatura != null) {
			examen.setAsignatura(asignatura);
			examen = examenRepo.save(examen);
		}
		return examen;
	}

	@Override
	@Transactional
	public void updateExamen(Examen examen) {
		if (examen != null) {
			examen = examenRepo.save(examen);
		}
	}

	@Override
	@Transactional
	public void deleteExamen(Examen examen) {
		examenRepo.delete(examen);
	}

	// Getters && Setters

	public ExamenRepository getExamenRepo() {
		return examenRepo;
	}

	public void setExamenRepo(ExamenRepository examenRepo) {
		this.examenRepo = examenRepo;
	}

	@Override
	public Boolean existeExamenByCodigo(String codigoExamen) {
		Examen ex = examenRepo.findExamenByCodigo(codigoExamen);
		boolean existe = false;
		if (ex != null) {
			existe = true;
		}
		return existe;
	}

	@Override
	public void generarActa(String codigoExamen) {
		Examen examen = examenRepo.findExamenByCodigo(codigoExamen);
		List<Student> estudiantes = this.getEstudiantesInsciptosAExamen(examen);
		ReportsService.imprimirActaExamen(estudiantes, examen);

	}

	@Override
	public List<Student> getEstudiantesInsciptosAExamen(Examen examen) {
		List<Inscripcion> inscripciones = inscripcionRepo
				.findInscripcionesByExamen(examen);
		List<Student> estudiantes = new ArrayList<Student>();
		for (Inscripcion i : inscripciones) {
			if (i.getIsValid()) {
				estudiantes.add(i.getEstudiante());
			}
		}
		return estudiantes;
	}

	public InscripcionRepository getInscripcionRepo() {
		return inscripcionRepo;
	}

	public void setInscripcionRepo(InscripcionRepository inscripcionRepo) {
		this.inscripcionRepo = inscripcionRepo;
	}

}

/**
 * 
 */
package edu.bedelias.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.repositories.AsignaturaRepository;
import edu.bedelias.repositories.EvaluacionRepository;
import edu.bedelias.repositories.StudentRepository;
import edu.bedelias.services.EvaluacionService;
import edu.bedelias.services.StudentService;
import edu.bedelias.utils.ReportsService;
import edu.bedelias.utils.SecUtils;

/**
 * @author Gas
 * 
 */
@Service(value = "studentServiceImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private EvaluacionRepository evaluacionRepo;

	@Autowired
	private EvaluacionService evaluacionService;

	@Autowired
	private AsignaturaRepository asignaturaRepository;

	public StudentServiceImpl() {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see edu.bedelias.services.StudentService#findStudentById(java.lang.Long)
	 */
	@Override
	public Student findStudentById(Long id) {
		return studentRepo.findOne(id);
	}

	@Override
	public List<Student> findAll() {
		return studentRepo.findAll();
	}

	@Override
	public Student findStudentByStudentNumber(String studentNum) {
		return studentRepo.findStudentByStudentNum(studentNum);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#createStudent(edu.bedelias.entities
	 * .Student)
	 */
	@Override
	@Transactional
	public Student createStudent(Student student) {
		if (student != null) {
			student = studentRepo.save(student);
		}
		return student;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#updateStudent(edu.bedelias.entities
	 * .Student)
	 */
	@Override
	@Transactional
	public void updateStudent(Student student) {
		if (student != null) {
			studentRepo.save(student);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#deleteStudent(edu.bedelias.entities
	 * .Student)
	 */
	@Override
	@Transactional
	public void deleteStudent(Student student) {
		if (student != null) {
			studentRepo.delete(student);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#findStudentByEmail(java.lang.String)
	 */
	@Override
	public Student findStudentByEmail(String email) {
		return studentRepo.findStudentByEmail(email);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#findStudentsByLastname(java.lang
	 * .String)
	 */
	@Override
	public List<Student> findStudentsByLastname(String lastname) {
		return studentRepo.findStudentByLastname(lastname);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.bedelias.services.StudentService#findStudentByCedula(java.lang.String
	 * )
	 */
	@Override
	public Student findStudentByCedula(String cedula) {
		return studentRepo.findStudentByCedula(cedula);
	}

	// Getters && Setters

	public StudentRepository getStudentRepo() {
		return studentRepo;
	}

	public void setStudentRepo(StudentRepository studentRepo) {
		this.studentRepo = studentRepo;
	}

	@Override
	public boolean existeStudentByCedula(String cedula) {
		Student student = studentRepo.findStudentByCedula(cedula);
		if (student == null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public boolean validarPase(String numPase, String institucion, String cedula) {
		String numPase1 = "1";
		String numPase2 = "2";
		String numPase3 = "3";
		String numPase4 = "4";
		String numPase5 = "19983";

		if (numPase.equals(numPase1) || numPase.equals(numPase2) || numPase.equals(numPase3) || numPase.equals(numPase4) || numPase.equals(numPase5)) {
			return true;
		}
		return false;
	}

	@Override
	public void generarEscolaridad(Student student, List<Evaluacion> evaluaciones) {
		ReportsService.imprimirEscolaridad(student, evaluaciones);
	}

	@Override
	public String generatePass(String cedula) {
		// genero la clave en base a la cédula
		String pass = SecUtils.hashPassword(cedula);

		// casteo a una clave del tamaño que usan en bedelías
		pass = pass.substring(pass.length() / 2, pass.length() / 2 + 6);
		return pass;

	}

	@Override
	public Student login(String cedula, String pass) {
		Student student = studentRepo.findStudentByCedula(cedula);
		// existe el estudiante, cédula ok
		if (student != null) {
			// las claves coinciden, login ok
			if (pass.equals(student.getPassword())) {
				return student;
			}
		}
		// cédula o clave tudo cagadu
		return null;
	}

	@Override
	public List<Asignatura> validarPreviasEstudianteCurso(Student student, Curso curso) {

		// Traigo las evalucaiones aprobadas a curso
		List<Evaluacion> evaluacionesCurso = evaluacionService.getEvaluacionesAprobadasByStudentAndCurso(student.getId());
		// Traigo las evaluaciones aprobadas a examen
		List<Evaluacion> evaluacionesExamen = evaluacionService.getEvaluacionesAprobadasByStudentAndExamen(student.getId());
		// Traigo las asignaturas previas de la asigantura q corresponde al
		// curso q me pasan por parametro
		List<Asignatura> asignaturasPrevias = asignaturaRepository.getPrevias(curso.getAsignatura().getId());
		
		List<Asignatura> asgisRet = null;

		// Cargo la lista de asignaturas q aprobo el estudiante ya sea por curso o por examen
		List<Asignatura> asignaturasAprobadas = new ArrayList<Asignatura>();
		for (Evaluacion e : evaluacionesCurso) {
			asignaturasAprobadas.add(e.getCurso().getAsignatura());
		}
		for (Evaluacion e : evaluacionesExamen) {
			asignaturasAprobadas.add(e.getExamen().getAsignatura());
		}

		// Itero por asignaturas para ir checkeando la lista de las previas
		HashMap<Long, Asignatura> retorno = new HashMap<Long, Asignatura>();
		if(asignaturasAprobadas.isEmpty()){
			asgisRet = asignaturasPrevias;
		} else {
			for (Asignatura asig : asignaturasPrevias) {
				for (Asignatura a : asignaturasAprobadas) {
					long aId = a.getId();
					long asigId = asig.getId();
					if (aId != asigId) {
						retorno.put(asig.getId(), asig);
					}
				}
			}
			asgisRet = new ArrayList<Asignatura>(retorno.values());
		}
		
		return asgisRet;
	}

	public EvaluacionRepository getEvaluacionRepo() {
		return evaluacionRepo;
	}

	public void setEvaluacionRepo(EvaluacionRepository evaluacionRepo) {
		this.evaluacionRepo = evaluacionRepo;
	}

	public EvaluacionService getEvaluacionService() {
		return evaluacionService;
	}

	public void setEvaluacionService(EvaluacionService evaluacionService) {
		this.evaluacionService = evaluacionService;
	}

	public AsignaturaRepository getAsignaturaRepository() {
		return asignaturaRepository;
	}

	public void setAsignaturaRepository(AsignaturaRepository asignaturaRepository) {
		this.asignaturaRepository = asignaturaRepository;
	}

}

/**
 * 
 */
package edu.bedelias.services.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.entities.Student;
import edu.bedelias.repositories.EvaluacionRepository;
import edu.bedelias.repositories.StudentRepository;
import edu.bedelias.services.StudentService;
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

		if (numPase.equals(numPase1) || numPase.equals(numPase2)
				|| numPase.equals(numPase3) || numPase.equals(numPase4)) {
			return true;
		}
		return false;
	}

	@Override
	public void generarEscolaridad(Student student,
			List<Evaluacion> evaluaciones) {
		// ReportsService.print(student, evaluaciones);
	}

	@Override
	public String generatePass(String cedula) {
		// genero la clave en base a la cédula
		String pass = SecUtils.hashPassword(cedula);
		
		// casteo a una clave del tamaño que usan en bedelías
		pass = pass.substring(0, 6);
		return pass;
		
	}

}

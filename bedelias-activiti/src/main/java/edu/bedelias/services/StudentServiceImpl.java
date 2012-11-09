/**
 * 
 */
package edu.bedelias.services;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Student;
import edu.bedelias.repositories.StudentRepository;

/**
 * @author Gas
 *
 */
@Service
@Transactional(readOnly = true)
public class StudentServiceImpl implements StudentService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private StudentRepository studentRepo;
	
	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentById(java.lang.Long)
	 */
	@Override
	public Student findStudentById(Long id) {
		return studentRepo.findOne(id);
	}

	@Override
	public Student findStudentByStudentNumber(UUID studentNum) {
		return studentRepo.findStudentByStudentNum(studentNum);
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#createStudent(edu.bedelias.entities.Student)
	 */
	@Override
	@Transactional
	public Student createStudent(Student student) {
		if (student != null) {
			student = studentRepo.save(student);
		}
		return student;
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#updateStudent(edu.bedelias.entities.Student)
	 */
	@Override
	@Transactional
	public void updateStudent(Student student) {
		if (student != null) {
			studentRepo.save(student);
		}
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#deleteStudent(edu.bedelias.entities.Student)
	 */
	@Override
	@Transactional
	public void deleteStudent(Student student) {
		if (student != null) {
			studentRepo.delete(student);
		}
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentByEmail(java.lang.String)
	 */
	@Override
	public Student findStudentByEmail(String email) {
		return studentRepo.findStudentByEmail(email);
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentsByLastname(java.lang.String)
	 */
	@Override
	public List<Student> findStudentsByLastname(String lastname) {
		return studentRepo.findStudentByLastname(lastname);
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentByCedula(java.lang.String)
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

}

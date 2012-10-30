/**
 * 
 */
package edu.bedelias.services;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.entities.Student;
import edu.bedelias.repositories.StudentRepository;

/**
 * @author Gas
 *
 */
public class StudentServiceImpl implements StudentService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	StudentRepository studentRepo;
	
	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentById(java.lang.Long)
	 */
	@Override
	public Student findStudentById(Long id) {
		return studentRepo.findOne(id);
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#createStudent(edu.bedelias.entities.Student)
	 */
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#updateStudent(edu.bedelias.entities.Student)
	 */
	@Override
	public void updateStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#deleteStudent(edu.bedelias.entities.Student)
	 */
	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentByEmail(java.lang.String)
	 */
	@Override
	public Student findStudentByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentsByLastname(java.lang.String)
	 */
	@Override
	public List<Student> findStudentsByLastname(String lastname) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see edu.bedelias.services.StudentService#findStudentByCedula(java.lang.String)
	 */
	@Override
	public Student findStudentByCedula(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

}

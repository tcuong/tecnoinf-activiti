/**
 * 
 */
package edu.bedelias.services;

import java.util.List;
import java.util.UUID;

import edu.bedelias.entities.Student;

/**
 * @author Administrador
 *
 */
public interface StudentService {

	/**
	 * CRUD ops go here
	 * 
	 */
	
	public Student createStudent(Student student);
	
	public void updateStudent(Student student);
	
	public void deleteStudent(Student student);
	
	// Misc stuff.
	public Student findStudentById(Long id);
	
	public Student findStudentByEmail(String email);
	
	public List<Student> findStudentsByLastname(String lastname);
	
	public Student findStudentByCedula(String cedula);

	Student findStudentByStudentNumber(UUID studentNum);
}

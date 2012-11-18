package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */
	public List<Student> findStudentByLastname(String lastname);

	public Student findStudentByStudentNum(String studentNum);

	public Student findStudentByEmail(String email);

	public Student findStudentByCedula(String cedula);
}

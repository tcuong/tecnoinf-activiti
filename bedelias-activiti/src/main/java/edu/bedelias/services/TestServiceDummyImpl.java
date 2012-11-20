package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Student;
import edu.bedelias.repositories.StudentRepository;

@Service(value = "testServiceDummyImpl")
@Transactional(readOnly = true)
public class TestServiceDummyImpl implements TestServiceDummy {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	@Transactional
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	// Getters && Setters
	
	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

}

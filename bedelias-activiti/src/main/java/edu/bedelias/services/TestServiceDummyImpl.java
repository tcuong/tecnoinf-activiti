package edu.bedelias.services;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Student;
import edu.bedelias.repositories.StudentRepository;

@Service(value = "testServiceDummyImpl")
@Transactional(readOnly = true)
public class TestServiceDummyImpl implements TestServiceDummy, JavaDelegate {

	@Autowired
	private StudentRepository studentRepository;

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@Override
	public void run() {
		System.out.println("ESTAMO EN EL SERVICE");
	}

	@Override
	public void run2() {
		System.out.println("ESTAMO EN EL SERVICE");

	}

	@Override
	@Transactional
	public Student create(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		this.create(new Student("Mario", "unCorreo@mail.net", "Cedula",
				new Date(System.currentTimeMillis())));

	}

}

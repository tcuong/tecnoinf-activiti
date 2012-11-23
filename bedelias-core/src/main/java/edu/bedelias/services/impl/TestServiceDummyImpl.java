package edu.bedelias.services.impl;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.services.TestServiceDummy;

@Service(value = "testServiceDummyImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class TestServiceDummyImpl implements TestServiceDummy {

	@Override
	public void pruebaService() {
		Logger logger = Logger.getLogger(TestServiceDummyImpl.class);
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
		logger.info("Estamos adentro del service");
		logger.info("++++++++++++++++++++++++++++++++++++++++++");
	}

	// @Autowired
	// private StudentRepository studentRepository;
	//
	// @Override
	// @Transactional
	// public Student create(Student student) {
	// return studentRepository.save(student);
	// }
	//
	// // Getters && Setters
	//
	// public StudentRepository getStudentRepository() {
	// return studentRepository;
	// }
	//
	// public void setStudentRepository(StudentRepository studentRepository) {
	// this.studentRepository = studentRepository;
	// }

}

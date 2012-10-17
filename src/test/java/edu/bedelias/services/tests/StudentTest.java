/**
 * 
 */
package edu.bedelias.services.tests;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.repositories.StudentRepository;

/**
 * @author Gas
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class StudentTest {

	@Autowired
	// private StudentService personService;
	private StudentRepository repo;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	// Getters && Setters

	// public StudentService getPersonService() {
	// return personService;
	// }
	//
	// public void setPersonService(StudentService personService) {
	// this.personService = personService;
	// }

	public StudentRepository getRepo() {
		return repo;
	}

	public void setRepo(StudentRepository repo) {
		this.repo = repo;
	}

}

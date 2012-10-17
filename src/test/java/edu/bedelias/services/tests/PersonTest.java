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

import edu.bedelias.repositories.PersonRepository;

/**
 * @author Gas
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class PersonTest {

	@Autowired
	// private PersonService personService;
	private PersonRepository repo;

	@Test
	public void test() {
		// fail("Not yet implemented");
	}

	// Getters && Setters

	// public PersonService getPersonService() {
	// return personService;
	// }
	//
	// public void setPersonService(PersonService personService) {
	// this.personService = personService;
	// }

	public PersonRepository getRepo() {
		return repo;
	}

	public void setRepo(PersonRepository repo) {
		this.repo = repo;
	}

}

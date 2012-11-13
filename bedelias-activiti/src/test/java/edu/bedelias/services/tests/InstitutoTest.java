package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Instituto;
import edu.bedelias.services.InstitutoService;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class InstitutoTest {

	@Autowired
	private InstitutoService institutoService;

	@Test
	public void test() {

		Instituto instituto = new Instituto();
		instituto.setName("Comision de Mamaderas");

		instituto = institutoService.createInstituto(instituto);

		assertNotNull("Instituto can't be null", instituto);
		assertNotNull("Instituto Name can't be null", instituto.getName());
		assertNotNull("Instituto Code can't be null", instituto.getCode());

//		assertEquals("instituto Code must be the same", instituto.getCode(),code); //FIXME
	}

}

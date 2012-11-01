package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class CarreerTest {
	
	@Autowired
	private CarreerService carreerService;
	
	@Test
	public void test(){
		
		UUID code = UUID.randomUUID();
		Carreer carreer = new Carreer();
		carreer.setName("Ingenieria en Cachufletas");
		carreer.setCode(code);
		
		carreer = carreerService.createCarreer(carreer);

		assertNotNull("Carreer can't be null", carreer);
		assertNotNull("Carreer Name can't be null", carreer.getName());
		assertNotNull("Carreer Code can't be null", carreer.getCode());
		
		assertEquals("Carreer Code must be the same", carreer.getCode(),
				code);
	}

}

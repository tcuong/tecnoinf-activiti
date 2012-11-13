package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
public class CarreerTest {
	
	@Autowired
	private CarreerService carreerService;
	
	@Test
	public void test(){
		Carreer carreer = new Carreer("Alguna carrera");
		carreer = carreerService.createCarreer(carreer);

		assertNotNull("Carreer can't be null", carreer);
		assertNotNull("Carreer Name can't be null", carreer.getName());
		assertNotNull("Carreer Code can't be null", carreer.getCode());
		
	}

}

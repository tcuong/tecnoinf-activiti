package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.DateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:DateServiceTest-context.xml" })
public class RemoteServiceTest {

	@Autowired
	private DateService dateService;
	
	@Autowired
	private CarreerService carreerService;

	@Test
	public void test() {
		Date date = dateService.getDate();
		System.out.println(date);
	}
	
	@Test
	public void remoteTest() {
		List<Carreer> carreras = carreerService.findAll();
		assertNotNull("carreras can't be null", carreras);
	}

}

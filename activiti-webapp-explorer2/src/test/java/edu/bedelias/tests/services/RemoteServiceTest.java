package edu.bedelias.tests.services;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.remote.DateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:DateServiceTest-context.xml" })
public class RemoteServiceTest {

	@Autowired
	private DateService dateService;

	@Test
	public void test() {
		Date date = dateService.getDate();
		System.out.println(date);
	}

}

package edu.bedelias.tests.activiti;

import static org.junit.Assert.assertNotNull;

import org.activiti.engine.ProcessEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextTest-c3p0.xml"} )
public class ActivitiEngineTest {

	@Test
	public void CallActivitiEngine() {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:activiti.cfg.xml");
		ProcessEngine pe = (ProcessEngine)cpx.getBean("processEngine");
		pe.getRuntimeService().startProcessInstanceByKey("GenerarActaDeCurso");
		
		assertNotNull("ProcessEngine can't be null", pe);
	}

}

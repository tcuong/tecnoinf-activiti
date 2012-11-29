package edu.bedelias.beans;

import java.util.HashMap;

import org.activiti.engine.ProcessEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public abstract class GenericActivitiMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	public GenericActivitiMB() {
	}

	public void instanciarProceso(String key, HashMap<String, Object> datos) {
		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:activiti.cfg.xml");
		ProcessEngine pe = (ProcessEngine) cpx.getBean("processEngine");
		pe.getRuntimeService().startProcessInstanceByKey(key, datos);
	}
}

package edu.bedelias.activiti.test;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class Test implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String tabla = (String) execution.getVariable("tabla");
		
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		
		System.out.println(tabla);
		
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
	}

}

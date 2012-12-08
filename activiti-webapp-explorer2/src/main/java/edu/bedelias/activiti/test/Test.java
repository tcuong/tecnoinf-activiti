package edu.bedelias.activiti.test;

import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.activiti.explorer.ui.form.ActaCursoON;

public class Test implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		List<ActaCursoON> ejemplos =  (List<ActaCursoON>) execution.getVariable("tabla");
		
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		
//		for (Ejemplo ejemplo : ejemplos) {
			System.out.println("****   " + ejemplos);
//		}
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
		System.out.println("0000000000000000000000000000000000000");
	}

}

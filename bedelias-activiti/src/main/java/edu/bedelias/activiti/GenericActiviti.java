package edu.bedelias.activiti;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

public class GenericActiviti implements JavaDelegate {

	/**
	 * Este metodo sera implementado en cada una de las clases que extenderan de
	 * esta Generic.
	 */
	@Override
	public void execute(DelegateExecution execution) throws Exception {
	}

	/**
	 * Este metodo sera implementado en cada una de las clases que extenderan de
	 * esta Generic.
	 * 
	 * @param execution
	 * @throws Exception
	 * 
	 */
	public void validate(DelegateExecution execution) throws Exception {
	}

}

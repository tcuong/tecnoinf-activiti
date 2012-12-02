package edu.bedelias.activiti.generaracta;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.bedelias.services.CursoService;

@Component
public class ValidarCodigo implements JavaDelegate {

	private CursoService cursoService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		cursoService = (CursoService) cpx.getBean("cursoService");

		String codigoCurso = execution.getVariable("codigoCurso").toString();
		Boolean existeCodigo = cursoService.existeCursoByCodigo(codigoCurso);
		execution.setVariable("existeCodigo", existeCodigo);
	}

	// Getters && Setters

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}

package edu.bedelias.activiti.generaracta;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.bedelias.services.CursoService;

@Component
public class ValidarCodigo implements JavaDelegate {

	@Autowired
	private CursoService cursoService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
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

package edu.bedelias.activiti.generaractacurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.activiti.GenericActiviti;
import edu.bedelias.services.CursoService;

public class ValidarCodigo extends GenericActiviti {

	@Autowired
	private CursoService cursoService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		boolean existeCodigo = cursoService.ExisteCursoByCodigo(execution
				.getVariable("input").toString());
		execution.setVariable("existeCodigo", existeCodigo);
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}

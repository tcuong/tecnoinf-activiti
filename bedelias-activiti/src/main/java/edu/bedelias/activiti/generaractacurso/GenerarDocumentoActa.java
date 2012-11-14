package edu.bedelias.activiti.generaractacurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.activiti.GenericActiviti;
import edu.bedelias.services.CursoService;

public class GenerarDocumentoActa extends GenericActiviti {

	@Autowired
	private CursoService cursoService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		cursoService.GenerarActa(execution.getVariable("input").toString());
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}

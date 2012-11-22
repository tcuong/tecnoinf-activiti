package edu.bedelias.activiti.generaracta;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.bedelias.services.CursoService;
import edu.bedelias.services.CursoServiceImpl;

public class ValidarCodigo implements JavaDelegate {

	private CursoService cursoService = new CursoServiceImpl();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String codigoCurso = execution.getVariable("codigoCurso").toString();
		Boolean existeCodigo = cursoService.existeCursoByCodigo(codigoCurso);
		execution.setVariable("existeCodigo", existeCodigo);
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}

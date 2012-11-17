package edu.bedelias.activiti.generaractacurso;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.services.TestServiceDummy;

public class ValidarCodigo {

	// private CursoService cursoService;
	@Autowired
	private TestServiceDummy serviceDummy;

	// @Override
	public void execute() throws Exception {

		serviceDummy.run();
		// boolean existeCodigo = cursoService.ExisteCursoByCodigo(execution
		// .getVariable("input").toString());
		// execution.setVariable("existeCodigo", existeCodigo);
	}

	public TestServiceDummy getServiceDummy() {
		return serviceDummy;
	}

	public void setServiceDummy(TestServiceDummy serviceDummy) {
		this.serviceDummy = serviceDummy;
	}

	// public CursoService getCursoService() {
	// return cursoService;
	// }
	//
	// public void setCursoService(CursoService cursoService) {
	// this.cursoService = cursoService;
	// }

}

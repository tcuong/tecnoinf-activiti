package edu.bedelias.activiti.generaractacurso;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.services.TestServiceDummy;

public class GenerarDocumentoActa {

	// @Autowired
	// private CursoService cursoService;

	@Autowired
	private TestServiceDummy serviceDummy;

	// @Override
	public void execute() throws Exception {
		serviceDummy.run2();
		// execution.setVariable("existeCodigo", true);
		// cursoService.GenerarActa(execution.getVariable("input").toString());
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
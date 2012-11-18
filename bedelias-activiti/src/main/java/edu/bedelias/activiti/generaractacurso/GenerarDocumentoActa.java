package edu.bedelias.activiti.generaractacurso;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.services.TestServiceDummy;

public class GenerarDocumentoActa implements Serializable {

	// @Autowired
	// private CursoService cursoService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private TestServiceDummy serviceDummy;

	public void run2() {
		serviceDummy.run2();
		// ${generarDocumentoActa.execute()}
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

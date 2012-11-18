package edu.bedelias.activiti.generaractacurso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.services.TestServiceDummy;

public class ValidarCodigo {

	@Autowired
	private TestServiceDummy serviceDummy;

	public ValidarCodigo() {
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext(
				"applicationContext");
	}

	public void run() {

		System.out.println("TAMOOOOOOOOOOOOO ACAAAAAAAAAAAAAAAAAAAAAAAA");
		//
		// serviceDummy.run();
		// // ${validarCodigo.execute()}
		// // boolean existeCodigo = cursoService.ExisteCursoByCodigo(execution
		// // .getVariable("input").toString());
		// // execution.setVariable("existeCodigo", existeCodigo);
	}

	public TestServiceDummy getServiceDummy() {
		return serviceDummy;
	}

	public void setServiceDummy(TestServiceDummy serviceDummy) {
		this.serviceDummy = serviceDummy;
	}

	// @Override
	// public void execute(DelegateExecution execution) throws Exception {
	// System.out.println("TAMOOOOOOOOOOOOO ACAAAAAAAAAAAAAAAAAAAAAAAA");
	//
	// }

	// public CursoService getCursoService() {
	// return cursoService;
	// }
	//
	// public void setCursoService(CursoService cursoService) {
	// this.cursoService = cursoService;
	// }

}

package edu.bedelias.activiti.generaracta;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.services.CursoService;

public class GenerarActa implements JavaDelegate {

	// @Autowired
	// private CursoService cursoService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// String codigoCurso = execution.getVariable("codigoCurso").toString();
		// try {
		// cursoService.generarActa(codigoCurso);
		// execution
		// .setVariable("msj", "El archivo fue genrado correctamente");
		//
		// } catch (Exception e) {
		// execution.setVariable("msj",
		// "Se ha producido un error, intente luego");
		// e.getLocalizedMessage();
		// }
	}

	// Getters && Setters

	// public CursoService getCursoService() {
	// return cursoService;
	// }
	//
	// public void setCursoService(CursoService cursoService) {
	// this.cursoService = cursoService;
	// }

}

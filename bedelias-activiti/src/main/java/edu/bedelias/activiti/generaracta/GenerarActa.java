package edu.bedelias.activiti.generaracta;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

import edu.bedelias.services.CursoService;
import edu.bedelias.services.CursoServiceImpl;

public class GenerarActa implements JavaDelegate {

	private CursoService cursoService = new CursoServiceImpl();

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String codigoCurso = execution.getVariable("codigoCurso").toString();
		try {
			cursoService.generarActa(codigoCurso);
			execution
					.setVariable("msj", "El archivo fue genrado correctamente");

		} catch (Exception e) {
			execution.setVariable("msj",
					"Se ha producido un error, intente luego");
			e.getLocalizedMessage();
		}
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

}

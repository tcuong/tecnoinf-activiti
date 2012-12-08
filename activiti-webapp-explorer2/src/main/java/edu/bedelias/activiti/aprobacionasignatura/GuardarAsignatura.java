package edu.bedelias.activiti.aprobacionasignatura;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Materia;
import edu.bedelias.enums.AprobacionEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.MateriaService;

public class GuardarAsignatura implements JavaDelegate {

	private AsignaturaService asignaturaService;

	private MateriaService materiaService;

	@Override
	public void execute(DelegateExecution execution) throws Exception {

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:applicationContextRemote.xml");
		asignaturaService = (AsignaturaService) cpx
				.getBean("asignaturaService");

		materiaService = (MateriaService) cpx.getBean("materiaService");

		Integer credits = Integer.valueOf(execution.getVariable("creditos")
				.toString());
		String codigo = execution.getVariable("codigo").toString();
		String nombre = execution.getVariable("nombre").toString();
		boolean isElectiva = (boolean) execution.getVariable("isElectiva");

		String materiaS = execution.getVariable("materia").toString();
		Long materiaId = Long.valueOf(materiaS);
		Materia materia = materiaService.getMateriaById(materiaId);

		Asignatura asignatura = new Asignatura();
		asignatura.setCode(codigo);
		asignatura.setCredits(credits);
		asignatura.setName(nombre);
		asignatura.setIsElectiva(isElectiva);

		String tipoAp = execution.getVariable("tipoAprobacion").toString();
		if (tipoAp.equals("1")) {
			asignatura.setTipoAprobacion(AprobacionEnum.EXAMEN);
		} else {
			asignatura.setTipoAprobacion(AprobacionEnum.CURSO);
		}

		asignatura = asignaturaService.createAsignatura(asignatura);
		materiaService.agregarAsignaturaMateria(materia, asignatura);

		execution.setVariable("msj", "Estimado docente, ");
		execution
				.setVariable("msj2",
						"Le informamos que su solicitud de aprobacion de asignatura ha sido aprobada");
		execution.setVariable("msj3", "");
		execution.setVariable("msj4",
				"Por mas informacion por favor dirijase a Bedelias.");
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

}

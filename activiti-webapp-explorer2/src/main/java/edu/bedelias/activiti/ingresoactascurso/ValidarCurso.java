package edu.bedelias.activiti.ingresoactascurso;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.services.CursoService;

public class ValidarCurso implements JavaDelegate {

	ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");

	private CursoService cursoService = (CursoService) cpx.getBean("cursoService");

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		try {
	
			// obtengo el id del curso
			String cursoId = (String) execution.getVariable("cursoId");
			
			// valido si existe
			Curso curso = cursoService.findCursoById(Long.valueOf(cursoId));
			
			if(curso != null){
				execution.setVariable("mensaje", "A continuacíon se despliegan los estudiantes que se encuentran en el Acta del curso");
				execution.setVariable("existeCurso", true);
			} else {
				// en caso negativo finalizo el proceso con un mensaje
				execution.setVariable("mensaje", "El curso seleccionado no existe en el sistema");
				execution.setVariable("existeCurso", false);
			}
		} catch (Exception e) {
			execution.setVariable("mensaje", "Se ha generado un error en el sistema, " + e.getMessage());
			execution.setVariable("existeCurso", false);
		}
		
		
		
		
	}

}

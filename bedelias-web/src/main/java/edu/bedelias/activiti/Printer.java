package edu.bedelias.activiti;

import java.util.Date;
import java.util.List;

import org.activiti.engine.delegate.DelegateExecution;
import org.springframework.beans.factory.annotation.Autowired;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Inscripcion;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.enums.TipoInscripcionEnum;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

public class Printer {

	@Autowired
	private InscripcionService inscripcionService;
	
	@Autowired
	private StudentService studentService;

	private Curso curso;
	private Student student;
	private PeriodoInscripcion periodoInscripcion;

	// variable para el timer que larga el proceso después del cierre del período de inscripción
	private String fechaFinDesistimiento;

	// estado de la inscripcion
	private boolean aprobada;
	
	public void guardarInscripcionCondicional(DelegateExecution execution) {
		
		// obtengo los datos
		student = (Student) execution.getVariable("student");
		curso = (Curso) execution.getVariable("curso");
		periodoInscripcion = (PeriodoInscripcion) execution.getVariable("periodo");
		
		// creo la inscripcion
		Inscripcion inscripcion = new Inscripcion();
		inscripcion.setCurso(curso);
		inscripcion.setEstudiante(student);
		inscripcion.setFechaInscripcion(new Date());
		inscripcion.setPeriodo(periodoInscripcion);
		inscripcion.setTipo(TipoInscripcionEnum.CURSO);
		
		// la guardo
		inscripcion = inscripcionService.createInscripcion(inscripcion);
		
		// obtengo del periodo de inscripcion la fecha de cierre
		//TODO hacer la lógica para guardar en esta variable la fecha con el formato solicitado por activiti
		fechaFinDesistimiento = "2012-12-14T12:35:00";
	}
	
	public void guardarDesistimiento(DelegateExecution execution) {
		
		// consulto si hay algun desistimiento para el estudiante y curso
		Inscripcion desistimiento = inscripcionService.getDesistimientoByStudentYCurso(student, curso);

		if (desistimiento == null) {
			// el estudiante NO desistio

			// seteo las variable que indica que el estudiante no desistio del curso
			execution.setVariable("desistio", false);

		} else {
			// el estudiante desistio del curso

			execution.setVariable("desistio", true);
			// agrego las variables para el envio del email con la confirmación del desistimiento
			execution.setVariable("para", "brunovierag@gmail.com");
			execution.setVariable("asunto", "Confirmación de Inscripción");
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", de parte de bedelías confirmamos el desistimiento al Curso " + curso.getName());
		}
	}
	
	public void validarPrevias(DelegateExecution execution){
		
		// valido las previas del curso para ver si la inscripcion es válida o no
		List<Asignatura> previas = studentService.validarPreviasEstudianteCurso(student, curso);
		
		if(previas.isEmpty()){
			// si valida correctamente las previas seguimos con las demás tareas
			aprobada = true;
			execution.setVariable("validacion", true);
			
			// seteo las variables para el envio del email
			execution.setVariable("para", "brunovierag@gmail.com");
			execution.setVariable("asunto", "Confirmación de Inscripción");
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", su inscripción al curso " + curso.getName() + "a sido aprobada.");
		} else {
			// si NO valida las previas pasamos a una manualTask para que la revisen
			aprobada = false;
			
			// setemos la variable que avisa que no se validaron
			execution.setVariable("validacion", false);
			
			String previasTexto = " ";
			for(Asignatura previa: previas){
				previasTexto = previasTexto + previa.getName() + " - ";
			}
			// setemos el mensaje que le vamos a mostrar al funcionario
			String mensaje = "Las siguientes previas no se validaron correctamente: " + previasTexto;
			mensaje = mensaje + " ----- Estudiante: " + student.getName() + " ----- Cédula:" + student.getCedula();
			execution.setVariable("mensaje", mensaje);
		}
	}
	
	public void guardarValidacionManual(DelegateExecution execution){
				
		// estas variables siempre van a ir por que son para el envio del email
		execution.setVariable("para", "brunovierag@gmail.com");
		execution.setVariable("asunto", "Confirmación de Inscripción");
		
		// obtengo el valor ingresado por el funcionario de bedelias para la inscripción		
		aprobada = (boolean) execution.getVariable("aprobada");
		
		if(aprobada){
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", su inscripción al curso " + curso.getName() + "a sido aprobada.");
		}else {
			execution.setVariable("cuerpo", "Estimado " + student.getName() + ", su inscripción al curso " + curso.getName() + 
					"ha sido REPROBADA en la validación de privas.");
		}
	}
	
	public void guardarInscripcionFinal(){
		
		// obtengo la inscripcion
		Inscripcion inscripcion = inscripcionService.getInscripcionByStudentYCurso(student, curso);
		
		// dependiendo el estado de la solicitud la guardo como valida o no
		if(aprobada){
			// la seteo como válida
			inscripcion.setIsValid(true);
		} else {
			// la seteo como NO válida
			inscripcion.setIsValid(false);
		}
		
		// la guardo
		inscripcionService.updateInscripcion(inscripcion);
		
		
		// limpio todas las variables
		aprobada = false;
		curso = null;
		student = null;
		inscripcion = null;
		fechaFinDesistimiento = "";
		periodoInscripcion = null;
		
		
	}
	
	public String getFechaFinDesistimiento() {
		return fechaFinDesistimiento;
	}

	public void setFechaFinDesistimiento(String fechaFinDesistimiento) {
		this.fechaFinDesistimiento = fechaFinDesistimiento;
	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PeriodoInscripcion getPeriodoInscripcion() {
		return periodoInscripcion;
	}

	public void setPeriodoInscripcion(PeriodoInscripcion periodoInscripcion) {
		this.periodoInscripcion = periodoInscripcion;
	}

	public boolean isAprobada() {
		return aprobada;
	}

	public void setAprobada(boolean aprobada) {
		this.aprobada = aprobada;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}

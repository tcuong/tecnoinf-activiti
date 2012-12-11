package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;

@ManagedBean
public class LoginMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;
	
	private String ciEstudiante;
	private String pass;

	public LoginMB() {
		super();
	}

	@PostConstruct
	public void init() {
		ciEstudiante = "47720720";
	}

	public void login(ActionEvent actionEvent) {
		
		// verifico que el logín sea correcto
		Student student = studentService.login(ciEstudiante, pass);
		
		// login correcto
		if(student != null){
			this.putInSession(this.cedula, student.getCedula());
			this.putInSession(this.nombre, student.getName());
			this.redirect("estudiante/home.xhtml");
		} else {
			//login incorrecto
			this.sendErrorMessage("Error", "Usuario o clave incorrecto");
		}
	}

	public void cerrarSesion() {
		this.clearSession();
		this.redirect("../home.xhtml");
	}

	public String getCiEstudiante() {
		return ciEstudiante;
	}

	public void setCiEstudiante(String ciEstudiante) {
		this.ciEstudiante = ciEstudiante;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}

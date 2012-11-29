package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	private String ciEstudiante;

	public LoginMB() {
		super();
	}

	@PostConstruct
	public void init() {
		ciEstudiante = "someCedula";
	}

	public void login() {
		// acá despues hay que guardar bien los datos del estudiante
		this.putInSession(this.cedula, ciEstudiante);
		this.putInSession(this.nombre, "Batman");
		this.redirect("estudiante/home.xhtml");
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

}

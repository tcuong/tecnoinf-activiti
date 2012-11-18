package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	private String cedula;

	public LoginMB() {
		super();
	}

	@PostConstruct
	public void init() {
		cedula = "someCedula";
	}

	public void login() {
		this.putInSession("ci_est", cedula);
		this.redirect("estudiante/home.xhtml");
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
}

package edu.bedelias.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MenuIzqMB extends GenericMB {

	private static final long serialVersionUID = 654566536803790092L;

	public MenuIzqMB() {
		super();
	}

	public void iniciarSesion(){
		redirect("login.xhtml");
	}
	
	public void noImplementada(){
		redirect("noImplementada.xhtml");
	}
	
	public void verPrevias(){
		redirect("previas.xhtml");
	}
}

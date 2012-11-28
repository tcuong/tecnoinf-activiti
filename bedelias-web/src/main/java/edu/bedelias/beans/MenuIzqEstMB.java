package edu.bedelias.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class MenuIzqEstMB extends GenericMB {

	private static final long serialVersionUID = 654566536803790092L;

	public MenuIzqEstMB() {
		super();
	}

	public String obtenerNombre(){
		estaLogueado();
		return (String) this.getFromSession(this.nombre);
	}
	
	public void inscripcionCurso() {
		redirect("../estudiante/inscripcionCurso.xhtml");
	}

	public void verInscripcionesCurso() {
		redirect("../estudiante/verInscripcionesCurso.xhtml");
	}
	
	public void noImplementada(){
		redirect("noImplementada.xhtml");
	}
	
	public void desistirInscripcion(){
		redirect("desistirInscripcion.xhtml");
	}
	
	public void verPrevias(){
		redirect("previas.xhtml");
	}
	
	public void previasDeQuien(){
		redirect("previasDeQuien.xhtml");
	}
}

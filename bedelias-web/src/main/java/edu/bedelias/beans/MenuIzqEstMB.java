package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class MenuIzqEstMB extends GenericMB{
	
	public MenuIzqEstMB(){
		super();
	}
	
	@PostConstruct
	public void init(){
		
	}
	
	public void inscripcionCurso(){
		redirect("../estudiante/inscripcionCurso.xhtml");
	}
}

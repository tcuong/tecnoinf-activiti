package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import edu.bedelias.entities.Curso;

@ManagedBean
public class InscripcionCursoMB extends GenericMB{
	
	List<Curso> curso;
	
	public InscripcionCursoMB(){
		super();
	}
	    
	@PostConstruct
	public void init(){
		
	}

}

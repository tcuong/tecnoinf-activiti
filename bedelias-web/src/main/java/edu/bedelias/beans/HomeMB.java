package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeMB extends GenericMB{
	
	public HomeMB(){
		super();
	}

	@PostConstruct
	public void init(){
		
	}
}

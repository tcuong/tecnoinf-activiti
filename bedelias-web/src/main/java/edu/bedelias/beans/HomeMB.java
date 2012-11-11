package edu.bedelias.beans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class HomeMB extends GenericMB {

	private static final long serialVersionUID = -3861848147354658912L;

	public HomeMB() {
		super();
	}

	@PostConstruct
	public void init() {

	}
}

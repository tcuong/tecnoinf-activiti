package edu.bedelias.entities;

import java.io.Serializable;


public class Materia implements Serializable{

	private static final long serialVersionUID = -4323903811661592684L;
	
	private Integer minCredits;

	public Integer getMinCredits() {
		return minCredits;
	}

	public void setMinCredits(Integer minCredits) {
		this.minCredits = minCredits;
	}

}

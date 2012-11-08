package edu.bedelias.entities;

import javax.persistence.Entity;

@Entity
public class Materia extends GenericEntityName {

	private static final long serialVersionUID = -4323903811661592684L;

	private Integer minCredits;

	public Integer getMinCredits() {
		return minCredits;
	}

	public void setMinCredits(Integer minCredits) {
		this.minCredits = minCredits;
	}

}

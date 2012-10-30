package edu.bedelias.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carreer implements Serializable{

	private static final long serialVersionUID = -7719015297725891812L;

		private Integer totalCredits;
	
	private String intermediateTitle;
	
	private Integer intermediateCredits;

	public Integer getTotalCredits() {
		return totalCredits;
	}

	public void setTotalCredits(Integer totalCredits) {
		this.totalCredits = totalCredits;
	}

	public String getIntermediateTitle() {
		return intermediateTitle;
	}

	public void setIntermediateTitle(String intermediateTitle) {
		this.intermediateTitle = intermediateTitle;
	}

	public Integer getIntermediateCredits() {
		return intermediateCredits;
	}

	public void setIntermediateCredits(Integer intermediateCredits) {
		this.intermediateCredits = intermediateCredits;
	}

	

}

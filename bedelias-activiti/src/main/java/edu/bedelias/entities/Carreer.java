package edu.bedelias.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Carreer extends GenericEntityName {

	private static final long serialVersionUID = -7719015297725891812L;

	private Integer totalCredits;
	private String intermediateTitle;
	private Integer intermediateCredits;

	@ManyToMany
	@JoinTable(name = "materia_carreer", joinColumns = @JoinColumn(name = "materia_id"), inverseJoinColumns = @JoinColumn(name = "carreer_id"))
	private List<Materia> materias;

	public Carreer() {
		super();
	}

	public Carreer(String nombreCarrera) {
		super();
		this.setName(nombreCarrera);
	}

	// Getters && Setters

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

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

}

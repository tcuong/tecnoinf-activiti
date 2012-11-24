package edu.bedelias.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import edu.bedelias.entities.generics.GenericEntityName;

@Entity
public class Carreer extends GenericEntityName {

	private static final long serialVersionUID = -7719015297725891812L;

	private Integer totalCredits;
	private String intermediateTitle;
	private Integer intermediateCredits;

	@ManyToMany
	@JoinTable(name = "CARRERA_MATERIA", joinColumns = @JoinColumn(name = "carrera_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"))
	private List<Materia> materias;

	public Carreer() {
		super();
		materias = new ArrayList<Materia>();
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

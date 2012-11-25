package edu.bedelias.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import edu.bedelias.entities.generics.GenericEntityName;

@Entity
public class Materia extends GenericEntityName {

	private static final long serialVersionUID = -4323903811661592684L;

	private Integer minCredits;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "AsigMaterias", joinColumns = @JoinColumn(name = "materia_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "asignatura_id", referencedColumnName = "id"))
	private List<Asignatura> asignaturas;

	public Materia() {
		super();
		asignaturas = new ArrayList<Asignatura>();
	}

	public Integer getMinCredits() {
		return minCredits;
	}

	public void setMinCredits(Integer minCredits) {
		this.minCredits = minCredits;
	}

	public List<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

}

/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * @author Administrador
 *
 */
@Entity
public class Student extends Person {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long studentNum;

	private Date fechaInscripcionFac;
	
	// Getters && Setters
	
	@Column(nullable = false)
	private Date inscriptionDate;

	public Long getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(Long studentNum) {
		this.studentNum = studentNum;
	}

	public Date getInscriptionDate() {
		return inscriptionDate;
	}

	public void setInscriptionDate(Date inscriptionDate) {
		this.inscriptionDate = inscriptionDate;
	}

	public Date getFechaInscripcionFac() {
		return fechaInscripcionFac;
	}

	public void setFechaInscripcionFac(Date fechaInscripcionFac) {
		this.fechaInscripcionFac = fechaInscripcionFac;
	}
	
}

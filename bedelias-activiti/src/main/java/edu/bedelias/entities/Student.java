/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * @author Administrador
 *
 */
@Entity
public class Student extends Person {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private UUID studentNum;

	@Column(nullable = false)
	private Date fechaInscripcionFac;
	
	public Student() {
		super();
		this.studentNum = UUID.randomUUID();
	}

	// Getters && Setters
	
	public UUID getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(UUID studentNum) {
		this.studentNum = studentNum;
	}

	public Date getFechaInscripcionFac() {
		return fechaInscripcionFac;
	}

	public void setFechaInscripcionFac(Date fechaInscripcionFac) {
		this.fechaInscripcionFac = fechaInscripcionFac;
	}
	
}

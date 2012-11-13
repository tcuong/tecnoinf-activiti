/**
 * 
 */
package edu.bedelias.entities;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Administrador
 * 
 */
@Entity
@Table(name = "Student")
public class Student extends Person {

	private static final long serialVersionUID = 1L;

	@Column(unique = true, nullable = false)
	private UUID studentNum; // FIXME

	@Column(nullable = false)
	private Date fechaInscripcionFac;

	public Student() {
		super();
		this.studentNum = UUID.randomUUID();
	}

	public Student(String name, String email, String cedula,
			Date fechaInscripcionFac) {
		super();
		this.studentNum = UUID.randomUUID();
		this.setName(name);
		this.setEmail(email);
		this.setCedula(cedula);
		this.fechaInscripcionFac = fechaInscripcionFac;
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

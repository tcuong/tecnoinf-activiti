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
	private String studentNum;

	@Column(nullable = false)
	private Date fechaInscripcionFac;
	
	private String numPase;
	
	private String institucion;
	
	@Column(nullable = false)
	private String password;

	public Student() {
		super();
		this.studentNum = UUID.randomUUID().toString();
	}

	public Student(String name, String email, String cedula,
			Date fechaInscripcionFac) {
		super();
		this.studentNum = UUID.randomUUID().toString();
		this.setName(name);
		this.setEmail(email);
		this.setCedula(cedula);
		this.fechaInscripcionFac = fechaInscripcionFac;
	}

	// Getters && Setters

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public Date getFechaInscripcionFac() {
		return fechaInscripcionFac;
	}

	public void setFechaInscripcionFac(Date fechaInscripcionFac) {
		this.fechaInscripcionFac = fechaInscripcionFac;
	}

	public String getNumPase() {
		return numPase;
	}

	public void setNumPase(String numPase) {
		this.numPase = numPase;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

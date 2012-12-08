package org.activiti.explorer.ui.form;

import java.io.Serializable;

import edu.bedelias.entities.Student;

public class ActaCursoON implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Student student;
	private String nota;
	
	public ActaCursoON(Student student, String nota){
		this.setStudent(student);
		this.nota = nota;
	}
	
	public String getNota() {
		return nota;
	}
	public void setNota(String nota) {
		this.nota = nota;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}

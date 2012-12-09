package org.activiti.explorer.ui.form;

import java.io.Serializable;

import com.vaadin.ui.TextField;

import edu.bedelias.entities.Student;

public class RowActaEstudiante implements Serializable {

	private static final long serialVersionUID = 1L;
	private TextField texto;
	private Student student;
	
	public RowActaEstudiante() {
		texto = new TextField("Nota");
		texto.setValue("No se presento");
	}
	
	public void setNota(String nota){
		texto.setValue(nota);
	}

	public TextField getTexto() {
		return texto;
	}

	public void setTexto(TextField texto) {
		this.texto = texto;
	}

	public String getNombre() {
		return student.getName();
	}

	public void setNombre(String nombre) {
	}

	public String getCedula() {
		return student.getCedula();
	}

	public void setCedula(String cedula) {
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

}

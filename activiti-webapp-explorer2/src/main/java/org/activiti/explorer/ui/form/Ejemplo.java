package org.activiti.explorer.ui.form;

import java.io.Serializable;

import com.vaadin.ui.TextField;

public class Ejemplo implements Serializable {

	private static final long serialVersionUID = 1L;
	private TextField texto;
	private String nombre;
	
	public Ejemplo() {
		setTexto(new TextField("Nota"));
		setNombre("");
	}

	public TextField getTexto() {
		return texto;
	}

	public void setTexto(TextField texto) {
		this.texto = texto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}

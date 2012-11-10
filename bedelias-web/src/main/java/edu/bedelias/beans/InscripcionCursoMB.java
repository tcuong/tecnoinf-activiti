package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.event.ActionEvent;

import edu.bedelias.activiti.TestCallActiviti;
import edu.bedelias.activiti.TestCallActivitiInterface;
import edu.bedelias.entities.Curso;

@ManagedBean(name="inscripcionCursoMB")
public class InscripcionCursoMB extends GenericMB {

	@ManagedProperty(value="#{testCallActiviti}")
	private TestCallActivitiInterface test;
	
	List<Curso> curso;
	String texto;

	@PostConstruct
	public void init() {

	}

	public InscripcionCursoMB() {
		super();
	}

	public void guardar() {
		test.test();
		
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public TestCallActivitiInterface getTest() {
		return test;
	}

	public void setTest(TestCallActivitiInterface test) {
		this.test = test;
	}
	
}

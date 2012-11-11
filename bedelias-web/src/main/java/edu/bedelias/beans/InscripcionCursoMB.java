package edu.bedelias.beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.bedelias.entities.Curso;
import edu.bedelias.services.TestCallActiviti;

@ManagedBean(name = "inscripcionCursoMB")
@SessionScoped
public class InscripcionCursoMB extends GenericMB {

	private static final long serialVersionUID = -826514322630864126L;

	@ManagedProperty(value = "#{testCallActivitiImpl}")
	private TestCallActiviti test;

	private List<Curso> curso;
	private String texto;

	@PostConstruct
	public void init() {

	}

	public void guardar() {
		test.test();
		return;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public TestCallActiviti getTest() {
		return test;
	}

	public void setTest(TestCallActiviti test) {
		this.test = test;
	}

	public List<Curso> getCurso() {
		return curso;
	}

	public void setCurso(List<Curso> curso) {
		this.curso = curso;
	}

}

package edu.bedelias.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.bedelias.services.TestServiceDummy;

@ManagedBean(name = "testMB")
@SessionScoped
public class TestMB extends GenericMB {

	private static final long serialVersionUID = 1L;

	private String name = "Gaston!";
	
	@ManagedProperty("#{testServiceDummyImpl}")
	private TestServiceDummy testServiceDummy;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TestServiceDummy getTestServiceDummy() {
		return testServiceDummy;
	}

	public void setTestServiceDummy(TestServiceDummy testServiceDummy) {
		this.testServiceDummy = testServiceDummy;
	}
}

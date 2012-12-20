package edu.bedelias.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.utils.SpringUtils;

@SessionScoped
public abstract class GenericMB implements Serializable {

	private static final long serialVersionUID = 1L;

	protected String cedula = "ci";
	protected String nombre = "name";
	private ClassPathXmlApplicationContext cpx;
	
	public ClassPathXmlApplicationContext getClassPathXmlApplicationContext() {
		if (cpx == null) {
			cpx = new ClassPathXmlApplicationContext("classpath:applicationContextWeb.xml");
		}
		return cpx;
	}

	public GenericMB() {
	}

	public boolean estaLogueado() {
		String ci = (String) getFromSession(cedula);
		if (ci == null) {
			redirect("../login.xhtml");
			return false;
		}
		return true;
	}

	public void redirect(String url) {
		try {
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(url);
		} catch (IOException ex) {
			ex.getLocalizedMessage().toString();
		}
	}

	public void sendErrorMessage(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
	}

	public void sendWarnMessage(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
	}

	public void sendInfoMessage(String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

	protected void putInSession(String property, Object value) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.put(property, value);
	}

	protected void removeFromSession(Object object) {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.remove(object);
	}

	protected void clearSession() {
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap()
				.clear();
	}

	public Object getFromSession(String property) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get(property);
	}

	protected boolean isInSession(String property) {
		return FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().containsKey(property);
	}

	public GenericMB getManagedBean(String beanName) {
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		GenericMB neededBean = (GenericMB) FacesContext.getCurrentInstance()
				.getApplication().getELResolver()
				.getValue(elContext, null, beanName);
		return neededBean;
	}

	public void addManagedBeanFromSession(GenericMB bean) {
		FacesContext
				.getCurrentInstance()
				.getExternalContext()
				.getSessionMap()
				.put(SpringUtils.convertToSpringName(bean.getClass()
						.getSimpleName()), bean);
	}
	
}

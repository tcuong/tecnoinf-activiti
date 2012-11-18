package edu.bedelias.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import edu.bedelias.utils.SpringUtils;

public abstract class GenericMB implements Serializable {

	private static final long serialVersionUID = 2680337680422935387L;

	public GenericMB() {
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

	protected Object getFromSession(String property) {
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

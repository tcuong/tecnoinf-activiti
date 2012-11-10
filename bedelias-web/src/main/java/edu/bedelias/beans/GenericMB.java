package edu.bedelias.beans;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericMB{
	
	public GenericMB(){
	}

    public void redirect(String url) {
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(url);
        } catch (IOException ex) {
            ex.getLocalizedMessage().toString();
        }
    }

    public void sendErrorMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, summary, detail));
    }

    public void sendWarnMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
    }

    public void sendInfoMessage(String summary, String detail) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
    }

    protected void putInSession(String property, Object value) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(property, value);
    }

    protected void removeFromSession(Object object) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove(object);
    }

    protected void clearSession() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
    }

    protected Object getFromSession(String propery) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(propery);
    }

    protected boolean isInSession(String property) {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().containsKey(property);
    }
}

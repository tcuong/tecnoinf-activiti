package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class TablaAuditarActaEstudiantesFormType extends AbstractFormType {

	public static final String TYPE_NAME = "tablaAuditarActa";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return TablaAuditarActaEstudiantesFormPropertyRenderer.datos();
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

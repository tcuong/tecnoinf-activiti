package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class TablaActaEstudiantesFormType extends AbstractFormType {

	public static final String TYPE_NAME = "tablaActaEstudiantes";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return TablaActaEstudiantesFormPropertyRenderer.datos();
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

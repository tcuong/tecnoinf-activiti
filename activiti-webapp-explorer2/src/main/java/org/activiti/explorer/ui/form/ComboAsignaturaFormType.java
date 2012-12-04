package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class ComboAsignaturaFormType extends AbstractFormType {

	public static final String TYPE_NAME = "comboAsignaturas";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return ComboAsignaturaFormPropertyRenderer.getId(propertyValue);
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

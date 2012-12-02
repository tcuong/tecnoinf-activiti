package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class ComboFormType extends AbstractFormType {

	public static final String TYPE_NAME = "comboCarreras";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return ComboFormPropertyRenderer.getId(propertyValue);
//		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

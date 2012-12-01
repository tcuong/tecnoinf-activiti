package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

public class ComboFormType extends AbstractFormType {

	public static final String TYPE_NAME = "combito";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
//		return ComboFormPropertyRenderer.getId(propertyValue);
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
//		return "Pito convertModelValueToFormValue";
//		return ComboFormPropertyRenderer.getId(modelValue.toString());
		return (String) modelValue;
	}

}

package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

public class TextAreaFormType extends AbstractFormType {

	public static final String TYPE_NAME = "textareaPito";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

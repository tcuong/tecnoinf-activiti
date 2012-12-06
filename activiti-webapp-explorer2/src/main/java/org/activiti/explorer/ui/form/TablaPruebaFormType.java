package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class TablaPruebaFormType extends AbstractFormType {

	public static final String TYPE_NAME = "tabla";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		System.out.println(propertyValue);
		return TablaPruebaFormPropertyRenderer.datos();
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

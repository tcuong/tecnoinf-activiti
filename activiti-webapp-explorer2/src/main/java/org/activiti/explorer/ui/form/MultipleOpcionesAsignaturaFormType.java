package org.activiti.explorer.ui.form;

import org.activiti.engine.impl.form.AbstractFormType;

/**
 * @author Brus
 */
public class MultipleOpcionesAsignaturaFormType extends AbstractFormType {

	public static final String TYPE_NAME = "multipleOpcionesAsignatura";

	public String getName() {
		return TYPE_NAME;
	}

	@Override
	public Object convertFormValueToModelValue(String propertyValue) {
		// la propertyValue vien de la siguiente manera [Helsinki, Paris, Madrid, Oslo]
		// por lo tanto tenemos que cambiar los nombres de las carreras por los ids correspondientes
		propertyValue = MultipleOpcionesAsignaturaFormPropertyRenderer.getIdOpciones(propertyValue);
		return propertyValue;
	}

	@Override
	public String convertModelValueToFormValue(Object modelValue) {
		return (String) modelValue;
	}

}

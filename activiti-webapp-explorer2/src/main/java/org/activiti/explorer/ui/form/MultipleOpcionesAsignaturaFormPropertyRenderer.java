/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.explorer.ui.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.ui.Field;
import com.vaadin.ui.OptionGroup;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.services.AsignaturaService;

/**
 * @author Brus
 */
public class MultipleOpcionesAsignaturaFormPropertyRenderer extends
		AbstractFormPropertyRenderer {

	public MultipleOpcionesAsignaturaFormPropertyRenderer() {
		super(MultipleOpcionesAsignaturaFormType.class);
	}

	 static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	 private static AsignaturaService asignaturaService = (AsignaturaService) cpx.getBean("asignaturaService");
	 
	 private static Map<String, String> asignaturas;

	@Override
	public Field getPropertyField(FormProperty formProperty) {
		// cargo todas las asignaturas del sistema
		cargarAsignaturas();
		
		// obtengo los nombres en una lista para armar lo optionGroup
		List<String> nombres = new ArrayList<>();
		
		for (String nombre: asignaturas.keySet()) {
			nombres.add(nombre);
		}
		OptionGroup grupoAsignaturas = new OptionGroup(formProperty.getName(), nombres);
		
		grupoAsignaturas.setMultiSelect(true);
		grupoAsignaturas.setNullSelectionAllowed(false);
		grupoAsignaturas.setImmediate(true);

		return grupoAsignaturas;
	}

	private static void cargarAsignaturas() {
		// obtengo las asignaturas del repo
		List<Asignatura> asignaturaAll = asignaturaService.findAll();
		
		// creo el hash y le agrego la información de las asignaturas
		asignaturas = new HashMap<String, String>();
		for (Asignatura asign : asignaturaAll) {
			asignaturas.put(asign.getName(), asign.getId().toString());
		}
	}

	public static String getIdOpciones(String propertyValue) {
		
		if(asignaturas == null ){
			cargarAsignaturas();
		}
		
		// me quedo con los nombres sin los []
		propertyValue = propertyValue.substring(1, propertyValue.length()-1);
		
		// me armo un array con los nombres de las carreras
		String[] carrerasNombre = propertyValue.split(",");
		
		String datosFinales = "";
		
		for (String nombre: carrerasNombre) {
			String id = asignaturas.get(nombre.trim());
			datosFinales = datosFinales + id + "|";  
		}
		return datosFinales;
	}

}

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

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;

/**
 * @author Brus
 */
public class MultipleOpcionesCarreraFormPropertyRenderer extends
		AbstractFormPropertyRenderer {

	public MultipleOpcionesCarreraFormPropertyRenderer() {
		super(MultipleOpcionesCarreraFormType.class);
	}

	 static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	 private static CarreerService carreerService = (CarreerService) cpx.getBean("carreerService");
	 
	 private static Map<String, String> carreras;

	@Override
	public Field getPropertyField(FormProperty formProperty) {

		cargarCarreras();
		
		List<String> nombres = new ArrayList<>();
		
		for (String nombre: carreras.keySet()) {
			nombres.add(nombre);
		}
		OptionGroup grupoCarreras = new OptionGroup(formProperty.getName(), nombres);

		grupoCarreras.setMultiSelect(true);
		grupoCarreras.setNullSelectionAllowed(false);
		grupoCarreras.setImmediate(true);

		return grupoCarreras;
	}

	private static void cargarCarreras() {
		// obtengo las carreras del repo
		List<Carreer> carrerasAll = carreerService.findAll();
		
		// creo el hash y le agrego la información de las carreras
		carreras = new HashMap<String, String>();
		for (Carreer carrera : carrerasAll) {
			carreras.put(carrera.getName(), carrera.getId().toString());
		}
	}

	public static String getIdOpciones(String propertyValue) {
		
		if(carreras == null ){
			cargarCarreras();
		}
		
		// me quedo con los nombres sin los []
		propertyValue = propertyValue.substring(1, propertyValue.length()-1);
		
		// me armo un array con los nombres de las carreras
		String[] carrerasNombre = propertyValue.split(",");
		
		String datosFinales = "";
		
		for (String nombre: carrerasNombre) {
			String id = carreras.get(nombre.trim());
			datosFinales = datosFinales + id + "|";  
		}
		return datosFinales;
	}

}

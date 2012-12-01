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

import java.util.HashMap;
import java.util.List;

import org.activiti.engine.form.FormProperty;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;

import edu.bedelias.entities.Carreer;
import edu.bedelias.services.CarreerService;

/**
 * @author Brunos vieras
 */
public class ComboFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public ComboFormPropertyRenderer() {
		super(ComboFormType.class);
	}

	@Autowired
	private CarreerService carreerService;
	
	private static final String[] cities = new String[] { "Berlin", "Brussels",
        "Helsinki", "Madrid", "Oslo", "Paris", "Stockholm" };

	private static HashMap<String, Integer> ids;  
			
			
	@Override
	public Field getPropertyField(FormProperty formProperty) {

		List<Carreer> carreras = carreerService.findAll();
		ComboBox combo = new ComboBox(formProperty.getName());
		
        for (Carreer carrera: carreras) {
            combo.addItem(carrera.getName());
        }

        combo.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
        combo.setImmediate(true);
        
		return combo;
	}
	
	public static String getId(String seleccion){
		if(ids == null){
			cargarHash();
		}
		return ids.get(seleccion).toString();
	}

	private static void cargarHash() {
		ids = new HashMap<>();
		for (int i = 0; i < cities.length; i++) {
            ids.put(cities[i], i);
        }
	}

	public CarreerService getCarreerService() {
		return carreerService;
	}

	public void setCarreerService(CarreerService carreerService) {
		this.carreerService = carreerService;
	}
	
}
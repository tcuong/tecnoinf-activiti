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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;

import edu.bedelias.entities.SolicitudAsignatura;
import edu.bedelias.services.SolicitudAsignaturaService;

/**
 * @author Brus
 */
public class ComboSolicitudAsignaturaFormPropertyRenderer extends
		AbstractFormPropertyRenderer {

	public ComboSolicitudAsignaturaFormPropertyRenderer() {
		super(ComboCarreraFormType.class);
	}

	static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
			"classpath:applicationContextRemote.xml");

	private static SolicitudAsignaturaService solicitudService = (SolicitudAsignaturaService) cpx
			.getBean("solicitudAsignaturaService");

	private static HashMap<String, Long> ids;

	@Override
	public Field getPropertyField(FormProperty formProperty) {

		List<SolicitudAsignatura> solicitudes = solicitudService.findall();
		ComboBox combo = new ComboBox(formProperty.getName());
		ids = new HashMap<>();
		for (SolicitudAsignatura solAs : solicitudes) {
			ids.put(solAs.getNombreAsignatura(), solAs.getId());
			combo.addItem(solAs.getNombreAsignatura());
		}

		combo.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		combo.setImmediate(true);

		return combo;
	}

	public static String getId(String seleccion) {
		if (ids == null) {
			cargarHash();
		} else if (seleccion == null) {
			return "";
		}
		return ids.get(seleccion).toString();
	}

	private static void cargarHash() {
		List<SolicitudAsignatura> solAs = solicitudService.findall();
		ids = new HashMap<>();
		for (SolicitudAsignatura s : solAs) {
			ids.put(s.getNombreAsignatura(), s.getId());
		}
	}

	public static SolicitudAsignaturaService getSolicitudService() {
		return solicitudService;
	}

	public static void setSolicitudService(
			SolicitudAsignaturaService solicitudService) {
		ComboSolicitudAsignaturaFormPropertyRenderer.solicitudService = solicitudService;
	}

}

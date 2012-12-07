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

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.ItemClickEvent;
import com.vaadin.event.ItemClickEvent.ItemClickListener;
import com.vaadin.ui.Field;
import com.vaadin.ui.Table;

import edu.bedelias.services.AsignaturaService;

/**
 * @author Brus
 */
public class TablaPruebaFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public TablaPruebaFormPropertyRenderer() {
		super(TablaPruebaFormType.class);
	}

	static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private static AsignaturaService asignaturaService = (AsignaturaService) cpx.getBean("asignaturaService");
	
	static Table table;

	@Override
	public Field getPropertyField(FormProperty formProperty) {
		table = new Table();
        table.setWidth("100%");
        
        BeanItemContainer<Ejemplo> bic = new BeanItemContainer<Ejemplo>(Ejemplo.class);
        
//        List<Asignatura> asignaturas = asignaturaService.findAll(); 
//        for(Asignatura asig : asignaturas ) {
        for (int i = 0; i < 3; i++) {
        	Ejemplo ej = new Ejemplo();
        	ej.setNombre("tato");
			bic.addItem(ej);
		}
        
        table.setContainerDataSource(bic);
        
        // set column headers
        table.setVisibleColumns(new Object[]{"nombre", "texto"});
        table.setColumnHeaders(new String[]{"Nombre", "Nota"});
        table.setEditable(false);
        
        
        table.addListener(new ItemClickListener() {
            public void itemClick(ItemClickEvent event) {
                if (event.getButton() == ItemClickEvent.BUTTON_RIGHT) {
                    // you can handle left/right/middle -mouseclick
                }

                if (event.isDoubleClick()) {
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println(" - " + table.getValue());
                    System.out.println(" - " + event.getItem());
                    System.out.println(" - " + event.getItemId());
                    System.out.println(" - " + event.getPropertyId());
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                    System.out.println("00000000000000000000000000000000000000000000000000000000000000");
                }
            }
        });
        
        
		return table;
	}
	
	public static String datos(){
		 BeanItemContainer<Ejemplo> bic = (BeanItemContainer<Ejemplo>) table.getContainerDataSource();

		 for (Ejemplo ej : bic.getItemIds() ) {
			 System.out.println("00000000000000000000000000000000000000000000000000000000000000");
             System.out.println("0000000000000000000000000");
             System.out.println(ej.getTexto().getValue());
             System.out.println("0000000000000000000000000");
             System.out.println("00000000000000000000000000000000000000000000000000000000000000");
		}
		 
		return (String) table.getData();
	}

	public static AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public static void setAsignaturaService(AsignaturaService asignaturaService) {
		TablaPruebaFormPropertyRenderer.asignaturaService = asignaturaService;
	}
}

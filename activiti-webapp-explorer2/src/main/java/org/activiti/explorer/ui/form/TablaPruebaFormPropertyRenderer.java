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
import java.util.HashSet;
import java.util.List;

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.ui.Field;
import com.vaadin.ui.Table;

import edu.bedelias.entities.Asignatura;
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
	
	static Table table = new Table();
	

    HashMap<Object, String> markedRows = new HashMap<Object, String>();
    HashMap<Object, HashSet<Object>> markedCells = new HashMap<Object, HashSet<Object>>();

    static final Action ACTION_RED = new Action("red");
    static final Action ACTION_BLUE = new Action("blue");
    static final Action ACTION_GREEN = new Action("green");
    static final Action ACTION_NONE = new Action("none");
    static final Action[] ACTIONS = new Action[] { ACTION_RED, ACTION_GREEN, ACTION_BLUE, ACTION_NONE };

	@Override
	public Field getPropertyField(FormProperty formProperty) {
			
		
	    // size
        table.setWidth("100%");
//        table.setHeight("370px");
        
        BeanItemContainer<Asignatura> bic = new BeanItemContainer<Asignatura>(Asignatura.class);
        
//        for (int i = 0; i < 11; i++) {
//        	Asignatura asig = new Asignatura();
//        	asig.setName("Concha");
//        	bic.addItem(asig);
//			
//		}

        List<Asignatura> asignaturas = asignaturaService.findAll(); 
        for(Asignatura asig : asignaturas ) {
			bic.addItem(asig);
		}
        
        table.setContainerDataSource(bic);
        // set column headers
        table.setVisibleColumns(new Object[]{"name"});
        table.setColumnHeaders(new String[]{"Nombre"});
        table.setEditable(true);
        
        
        
        
//        // Column width
//        table.setColumnExpandRatio("name", 1);
//        table.setColumnWidth("short", 70);

//        table.addActionHandler(new Action.Handler() {
//            public Action[] getActions(Object target, Object sender) {
//                return ACTIONS;
//            }
//
//            public void handleAction(Action action, Object sender, Object target) {
//                markedRows.remove(target);
//                if (!ACTION_NONE.equals(action)) {
//                    // we're using the cations caption as stylename as well:
//                    markedRows.put(target, action.getCaption());
//                }
//                // this causes the CellStyleGenerator to return new styles,
//                // but table can't automatically know, we must tell it:
////                table.refreshRowCache();
//            }
//
//        });

        // style generator
//        table.setCellStyleGenerator(new CellStyleGenerator() {
//            public String getStyle(Object itemId, Object propertyId) {
//                if (propertyId == null) {
//                    // no propertyId, styling row
//                    return (markedRows.get(itemId));
//                } else if (propertyId.equals("Email")) {
//                    // style the generated email column
//                    return "email";
//                } else {
//                    HashSet<Object> cells = markedCells.get(itemId);
//                    if (cells != null && cells.contains(propertyId)) {
//                        // marked cell
//                        return "marked";
//                    } else {
//                        // no style
//                        return null;
//                    }
//                }
//
//            }
//
//        });

//        // toggle cell 'marked' styling when double-clicked
//        table.addListener(new ItemClickListener() {
//            public void itemClick(ItemClickEvent event) {
//                if (event.getButton() == ItemClickEvent.BUTTON_RIGHT) {
//                    // you can handle left/right/middle -mouseclick
//                }
//
//                if (event.isDoubleClick()) {
//                    Object itemId = event.getItemId();
//                    Object propertyId = event.getPropertyId();
//                    HashSet<Object> cells = markedCells.get(itemId);
//                    if (cells == null) {
//                        cells = new HashSet<Object>();
//                        markedCells.put(itemId, cells);
//                    }
//                    if (cells.contains(propertyId)) {
//                        // toggle marking off
//                        cells.remove(propertyId);
//                    } else {
//                        // toggle marking on
//                        cells.add(propertyId);
//                    }
//                    // this causes the CellStyleGenerator to return new styles,
//                    // but table can't automatically know, we must tell it:
////                    table.refreshRowCache();
//                }
//            }
//        });

        // Editing
        // we don't want to update container before pressing 'save':
//        table.setWriteThrough(false);
        // edit button
//        final Button editButton = new Button("Edit");
//        editButton.addListener(new Button.ClickListener() {
//            public void buttonClick(ClickEvent event) {
//                table.setEditable(!table.isEditable());
//                editButton.setCaption((table.isEditable() ? "Save" : "Edit"));
//            }
//        });
		
		
		
		
		return table;
	}
	
	public static String datos(){
		return (String) table.getData();
	}

	public static AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public static void setAsignaturaService(AsignaturaService asignaturaService) {
		TablaPruebaFormPropertyRenderer.asignaturaService = asignaturaService;
	}
}

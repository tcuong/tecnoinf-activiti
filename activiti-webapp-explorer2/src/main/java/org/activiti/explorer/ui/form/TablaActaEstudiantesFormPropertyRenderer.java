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
import java.util.List;

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Field;
import com.vaadin.ui.Table;

import edu.bedelias.entities.Student;
import edu.bedelias.services.StudentService;

/**
 * @author Brus
 */
public class TablaActaEstudiantesFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public TablaActaEstudiantesFormPropertyRenderer() {
		super(TablaActaEstudiantesFormType.class);
	}

	static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private static StudentService studentService = (StudentService) cpx.getBean("studentService");
	
	static Table table;

	@Override
	public Field getPropertyField(FormProperty formProperty) {
		table = new Table();
        table.setWidth("100%");
        
        BeanItemContainer<RowActaEstudiante> bic = new BeanItemContainer<RowActaEstudiante>(RowActaEstudiante.class);
        
        
        // falta obtener todos los estudiantes del curso seleccionado
        Student student = studentService.findStudentByCedula("someCedula");
        
    	RowActaEstudiante ej = new RowActaEstudiante();
    	ej.setStudent(student);
		bic.addItem(ej);
        
        table.setContainerDataSource(bic);
        
        // set column headers
        table.setVisibleColumns(new Object[]{"nombre", "texto"});
        table.setColumnHeaders(new String[]{"Nombre", "Nota"});
        table.setEditable(false);
        
		return table;
	}
	
	public static List<ActaCursoON> datos(){
		 @SuppressWarnings("unchecked")
		 // obtengo todos los objetos de la tabla
		BeanItemContainer<RowActaEstudiante> bic = (BeanItemContainer<RowActaEstudiante>) table.getContainerDataSource();
		 
		 // creo una lista de objetos de negocio
		 List<ActaCursoON> ejemplos = new ArrayList<>();
		 
		 // la cargo con los datos de la tabla
		 for (RowActaEstudiante ej : bic.getItemIds() ) {
			 ejemplos.add(new ActaCursoON(ej.getStudent(), ej.getTexto().getValue().toString()));
		}
		 
		return ejemplos;
	}

}

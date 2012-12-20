package org.activiti.explorer.ui.form;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Field;
import com.vaadin.ui.Table;

import edu.bedelias.entities.Evaluacion;
import edu.bedelias.services.EvaluacionService;

/**
 * @author Brus
 */
public class TablaAuditarActaEstudiantesFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public TablaAuditarActaEstudiantesFormPropertyRenderer() {
		super(TablaAuditarActaEstudiantesFormType.class);
	}

	static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private static EvaluacionService evaluacionService = (EvaluacionService) cpx.getBean("evaluacionService");
	
	static Table table;

	@Override
	public Field getPropertyField(FormProperty formProperty) {
		

		String cursoId = formProperty.getValue();
		
		table = new Table();
        table.setWidth("100%");
        
        BeanItemContainer<RowActaEstudiante> bic = new BeanItemContainer<RowActaEstudiante>(RowActaEstudiante.class);
        
        // falta obtener todos los estudiantes del curso seleccionado
        List<Evaluacion> evaluaciones = evaluacionService.getEvaluacionesByCurso(Long.valueOf(cursoId));
        
        
    	for (Evaluacion evaluacion: evaluaciones) {
    		RowActaEstudiante fila = new RowActaEstudiante();
    		fila.setStudent(evaluacion.getEstudiante());
    		if(evaluacion.getResultado() != null){
    			fila.setNota(evaluacion.getResultado().toString());
    		}
    		bic.addItem(fila);
		}
        
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

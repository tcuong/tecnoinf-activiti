package org.activiti.explorer.ui.form;

import java.util.HashMap;
import java.util.List;

import org.activiti.engine.form.FormProperty;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.vaadin.ui.AbstractSelect.Filtering;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Field;

import edu.bedelias.entities.Curso;
import edu.bedelias.services.CursoService;

/**
 * @author Brus
 */
public class ComboCursoFormPropertyRenderer extends AbstractFormPropertyRenderer {

	public ComboCursoFormPropertyRenderer() {
		super(ComboCursoFormType.class);
	}

	static ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("classpath:applicationContextRemote.xml");
	private static CursoService cursoService = (CursoService) cpx.getBean("cursoService");

	private static HashMap<String, Curso> ids;
	
	@Override
	public Field getPropertyField(FormProperty formProperty) {

		List<Curso> cursos = cursoService.findAll();
		ComboBox combo = new ComboBox(formProperty.getName());
		ids = new HashMap<>();
		for (Curso curso : cursos) {
			ids.put(curso.getName(), curso);
			combo.addItem(curso.getName());
		}
		
		combo.setFilteringMode(Filtering.FILTERINGMODE_CONTAINS);
		combo.setImmediate(true);
		return combo;
	}

	public static String getCurso(String seleccion) {
		if (ids == null) {
			cargarHash();
		} else if(seleccion == null){
			return null;
		}
		return ids.get(seleccion).getId().toString();
	}

	private static void cargarHash() {
		List<Curso> cursos = cursoService.findAll();
		ids = new HashMap<>();
		for (Curso curso : cursos) {
			ids.put(curso.getName(), curso);
		}
	}

	public static CursoService getCursoService() {
		return cursoService;
	}

	public static void setCursoService(CursoService cursoService) {
		ComboCursoFormPropertyRenderer.cursoService = cursoService;
	}
	
}

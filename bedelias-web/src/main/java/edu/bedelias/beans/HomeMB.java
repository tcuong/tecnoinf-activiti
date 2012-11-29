package edu.bedelias.beans;

import java.util.HashMap;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HomeMB extends GenericActivitiMB {

	private static final long serialVersionUID = -3861848147354658912L;

	public HomeMB() {
		super();
	}
	
	public void instanciarProceso(){
		
		HashMap<String, Object> datos = new HashMap<>();
		datos.put("saludo", "Hola amiguito vamos a jugar????!!!!!!");
		
		String key = "prueba1";
		
		instanciarProceso(key, datos);
		
	}

}

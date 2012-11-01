package edu.bedelias.services;

import edu.bedelias.entities.Inscripcion;

public interface InscripcionService {
	
	public Inscripcion createInscripcion(Inscripcion inscripcion);
	
	public void updateInscripcion(Inscripcion inscripcion);
	
	public void deleteInscripcion(Inscripcion inscripcion);

}

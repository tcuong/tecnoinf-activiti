package edu.bedelias.services;

import edu.bedelias.entities.Materia;
import edu.bedelias.entities.SolicitudAsignatura;

public interface SolicitudAsignaturaService {

	public SolicitudAsignatura createSolicitud(
			SolicitudAsignatura solicitudAsignatura, Materia materia);

}

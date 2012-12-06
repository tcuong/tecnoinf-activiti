package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.SolicitudAsignatura;

public interface SolicitudAsignaturaService {

	public SolicitudAsignatura createSolicitud(
			SolicitudAsignatura solicitudAsignatura, Long materiaId);

	public List<SolicitudAsignatura> findall();
}

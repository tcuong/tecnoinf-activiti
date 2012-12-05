package edu.bedelias.services;

import edu.bedelias.entities.Minuta;
import edu.bedelias.entities.SolicitudAsignatura;

public interface MinutaService {

	public Minuta createMinuta(Minuta minuta,
			SolicitudAsignatura solicitudAsignatura);

}

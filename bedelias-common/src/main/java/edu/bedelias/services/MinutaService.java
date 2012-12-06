package edu.bedelias.services;

import edu.bedelias.entities.Minuta;

public interface MinutaService {

	public Minuta createMinuta(Minuta minuta, Long solicitudAsignaturaId);

}

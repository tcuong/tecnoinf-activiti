package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Carreer;

public interface CarreerService {

	public Carreer createCarreer(Carreer carreer);

	public void updateCarreer(Carreer carreer);

	public void deleteCarreer(Carreer carreer);

	public List<Carreer> getCarrerasById(List<Long> ids);

	public void createCarreer(List<Carreer> carreras);

	public List<Carreer> findAll();
	
	public Carreer findCarreer(Carreer c);
	
	public Carreer findCarreer(Long carreerId);

}

package edu.bedelias.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.repositories.CarreerRepository;

@Service
@Transactional(readOnly = true)
public class CarreerServiceImpl implements CarreerService {

	@Autowired
	private CarreerRepository carreerRepo;

	@Override
	@Transactional
	public Carreer createCarreer(Carreer carreer) {
		if (carreer != null) {
			carreer = carreerRepo.save(carreer);
		}
		return carreer;
	}

	@Override
	@Transactional
	public void updateCarreer(Carreer carreer) {
		if (carreer != null) {
			carreerRepo.save(carreer);
		}
	}

	@Override
	@Transactional
	public void deleteCarreer(Carreer carreer) {
		if (carreer != null) {
			carreerRepo.delete(carreer);
		}
	}

	@Override
	public List<Carreer> getCarrerasById(List<Long> ids) {
		List<Carreer> carreras = new ArrayList<Carreer>();
		for (Long id : ids) {
			Carreer c = carreerRepo.findOne(id);
			if (c != null) {
				carreras.add(c);
			}
		}
		return carreras;
	}

	// Getters && Setters

	public CarreerRepository getCarreerRepo() {
		return carreerRepo;
	}

	public void setCarreerRepo(CarreerRepository carreerRepo) {
		this.carreerRepo = carreerRepo;
	}

}

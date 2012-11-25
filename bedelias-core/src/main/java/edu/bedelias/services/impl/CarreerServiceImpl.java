package edu.bedelias.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Materia;
import edu.bedelias.repositories.CarreerRepository;
import edu.bedelias.services.CarreerService;

@Service
@Scope(value = "session")
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

	@Override
	public List<Materia> findMateriaByCarreerId(Long id) {

		// return carreerRepo.getMateriasByCarreerId(id);
		return null;
	}

	// Getters && Setters

	public CarreerRepository getCarreerRepo() {
		return carreerRepo;
	}

	public void setCarreerRepo(CarreerRepository carreerRepo) {
		this.carreerRepo = carreerRepo;
	}

	@Override
	public void createCarreer(List<Carreer> carreras) {
		if (carreras != null) {
			this.carreerRepo.save(carreras);
		}

	}

	@Override
	public List<Carreer> findAll() {
		return carreerRepo.findAll();
	}

	@Override
	public Carreer findCarreer(Carreer c) {
		return findCarreer(c.getId());
	}

	@Override
	public Carreer findCarreer(Long carreerId) {
		try {
			return carreerRepo.findOne(carreerId);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@Transactional
	public Carreer agregarMateriaACarrera(Carreer carreer, Materia materia) {
		List<Materia> materias = carreer.getMaterias();// Ir a buscarlas al repo
		if (materias == null) {
			materias = new ArrayList<Materia>();
		}
		materias.add(materia);
		carreer.setMaterias(materias);
		carreer = carreerRepo.save(carreer);
		return carreer;
	}

}

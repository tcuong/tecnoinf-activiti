package edu.bedelias.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Carreer;

@Service
@Transactional(readOnly = true)
public class CarreerServiceImpl implements CarreerService {

	@Override
	public Carreer createCarreer(Carreer carreer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCarreer(Carreer carreer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCarreer(Carreer carreer) {
		// TODO Auto-generated method stub

	}

}

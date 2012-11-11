package edu.bedelias.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Instituto;
import edu.bedelias.repositories.InstitutoRepository;

@Service
@Transactional(readOnly = true)
public class InstitutoServiceImpl implements InstitutoService {

	@Autowired
	private InstitutoRepository institutoRepo;
	
	@Override
	@Transactional
	public Instituto createInstituto(Instituto instituto) {
		if (instituto != null) {
			instituto = institutoRepo.save(instituto);
		}
		return instituto;
	}

	@Override
	@Transactional
	public void updateInstituto(Instituto instituto) {
		if (instituto != null) {
			instituto = institutoRepo.save(instituto);
		}
	}

	@Override
	@Transactional
	public void deleteInstituto(Instituto instituto) {
		institutoRepo.delete(instituto);
	}

	// Getters && Setters
	public InstitutoRepository getInstitutoRepo() {
		return institutoRepo;
	}

	public void setInstitutoRepo(InstitutoRepository institutoRepo) {
		this.institutoRepo = institutoRepo;
	}

}

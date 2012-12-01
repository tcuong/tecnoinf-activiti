package edu.bedelias.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import edu.bedelias.repositories.StudentRepository;
import edu.bedelias.services.DateService;

@Service
@Scope(value = "session")
public class DateServiceImpl implements DateService {

	@Autowired
	private StudentRepository repo;

	@Override
	public Date getDate() {
		if (repo != null) {
			return new Date();
		}

		return null;
	}

	// Sample getters && setters
	
	public StudentRepository getRepo() {
		return repo;
	}

	public void setRepo(StudentRepository repo) {
		this.repo = repo;
	}

}

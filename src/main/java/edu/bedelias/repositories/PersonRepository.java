package edu.bedelias.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{

	/**
	 * CRUD ops are already part of JPARepository
	 * @param name
	 * @return
	 */
	public List<Person> findPersonByName(String name);
}

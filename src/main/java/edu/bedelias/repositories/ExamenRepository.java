package edu.bedelias.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.Examen;

public interface ExamenRepository extends JpaRepository<Examen, Long>{
	
	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */
	
	public List<Examen> findExamenByPeriodo(String periodo);
	
	public List<Examen> findExamenByFecha(Date fecha);

}

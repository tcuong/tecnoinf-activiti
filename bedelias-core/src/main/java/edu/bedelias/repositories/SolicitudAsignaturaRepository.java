package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.bedelias.entities.SolicitudAsignatura;

public interface SolicitudAsignaturaRepository extends
		JpaRepository<SolicitudAsignatura, Long> {

}

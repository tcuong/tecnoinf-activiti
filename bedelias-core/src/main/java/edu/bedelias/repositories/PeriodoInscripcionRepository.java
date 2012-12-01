package edu.bedelias.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface PeriodoInscripcionRepository extends
		JpaRepository<PeriodoInscripcion, Long> {

	/**
	 * CRUD ops are already part of JPARepository
	 * 
	 * @param name
	 * @return
	 */

	@Query("select p from PeriodoInscripcion p where p.isHabilitado = ?1 and p.tipoInscripcion = ?2")
	public PeriodoInscripcion getPeriodoActivoByTipo(boolean isActivo,
			TipoInscripcionEnum tipo);

}

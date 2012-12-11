package edu.bedelias.services;

import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.enums.TipoInscripcionEnum;

public interface PeriodoInscripcionService {

	public PeriodoInscripcion createPeriodoInscripcion(PeriodoInscripcion periodoInscripcion);

	public void updatePeriodoInscripcion(PeriodoInscripcion periodoInscripcion);

	public void deletePeriodoInscripcion(PeriodoInscripcion periodoInscripcion);

	public void test();

	public PeriodoInscripcion getPeriodoActivoByTipo(boolean isActivo,TipoInscripcionEnum tipo);

}

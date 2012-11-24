package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Asignatura;

public interface AsignaturaService {

	public Asignatura createAsignatura(Asignatura asignatura);

	public void updateAsignatura(Asignatura asignatura);

	public void deleteAsignatura(Asignatura asignatura);

	public Asignatura agregarPreviaAsignatura(Asignatura asignatura,
			Asignatura previa);

	public List<Asignatura> getPrevias(Long id);

}

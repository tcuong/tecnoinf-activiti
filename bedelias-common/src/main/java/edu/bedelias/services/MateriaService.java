package edu.bedelias.services;

import java.util.List;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Materia;

public interface MateriaService {

	public Materia createMateria(Materia materia);

	public void updateMateria(Materia materia);

	public void deleteMateria(Materia materia);

	public Materia agregarAsignaturaMateria(Materia materia,
			Asignatura asignatura);

	public List<Asignatura> getAsignaturasByMateriaId(Long id);

}
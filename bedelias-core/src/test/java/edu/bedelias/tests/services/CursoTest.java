package edu.bedelias.tests.services;

import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Curso;
import edu.bedelias.entities.Materia;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.AsignaturaService;
import edu.bedelias.services.CarreerService;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.MateriaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContextTest-c3p0.xml" })
public class CursoTest {

	@Autowired
	private CursoService cursoService;

	@Autowired
	private AsignaturaService asignaturaService;

	@Autowired
	private CarreerService carreerService;

	@Autowired
	private MateriaService materiaService;

	@Test
	public void test() {
		Materia materia1 = new Materia();
		materia1.setName("Juliana");
		materia1.setCode("codigo");
		materia1 = materiaService.createMateria(materia1);

		Materia materia2 = new Materia();
		materia2.setName("JulianSasasa");
		materia2.setCode("codigoQQQ");
		materia2 = materiaService.createMateria(materia2);

		Carreer carreer = new Carreer("Alguna carrera");
		carreer.setCode("lalalla");
		carreer = carreerService.agregarMateriaACarrera(carreer, materia1);
		carreer = carreerService.agregarMateriaACarrera(carreer, materia2);

		Asignatura asignatura = new Asignatura();
		asignatura.setCode("codigoAsig");
		asignatura.setName("Calculo");
		asignatura = asignaturaService.createAsignatura(asignatura);

		Asignatura asignatura1 = new Asignatura();
		asignatura1.setCode("codig000000");
		asignatura1.setName("Calculo 8 GIL!");
		asignatura1 = asignaturaService.createAsignatura(asignatura1);

		materiaService.agregarAsignaturaMateria(materia1, asignatura);
		materiaService.agregarAsignaturaMateria(materia2, asignatura1);

		Curso curso = new Curso();
		curso.setCode("codigoCurso");
		curso.setName("Plastilina 101 vesp.");
		curso.setSemestre("Par");
		curso.setHorario("Los jueves de 9 a 10:30");
		curso.setFechaInicio(new Date(System.currentTimeMillis()));
		curso.setFechaFin(new Date(System.currentTimeMillis()));
		curso.setTurno(TurnoEnum.VESPERTINO);
		curso.setAsignatura(asignatura);

		Curso curso1 = new Curso();
		curso1.setCode("coCurso");
		curso1.setName("Orto 102");
		curso1.setSemestre("Par");
		curso1.setHorario("Los jueves de 9 a 10:30");
		curso1.setFechaInicio(new Date(System.currentTimeMillis()));
		curso1.setFechaFin(new Date(System.currentTimeMillis()));
		curso1.setTurno(TurnoEnum.VESPERTINO);
		curso1.setAsignatura(asignatura1);

		curso = cursoService.createCurso(curso, asignatura);
		curso1 = cursoService.createCurso(curso1, asignatura1);

		List<Curso> cursos = cursoService.getCursosByCarrearId(carreer.getId());

		for (Curso c : cursos) {
			assertNotNull("Curso can't be null", c);
		}

		assertNotNull("Curso can't be null", curso);
		assertNotNull("Asignatura can't be null", curso.getAsignatura());
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public AsignaturaService getAsignaturaService() {
		return asignaturaService;
	}

	public void setAsignaturaService(AsignaturaService asignaturaService) {
		this.asignaturaService = asignaturaService;
	}

	public CarreerService getCarreerService() {
		return carreerService;
	}

	public void setCarreerService(CarreerService carreerService) {
		this.carreerService = carreerService;
	}

	public MateriaService getMateriaService() {
		return materiaService;
	}

	public void setMateriaService(MateriaService materiaService) {
		this.materiaService = materiaService;
	}

}

package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Curso;
import edu.bedelias.enums.TurnoEnum;
import edu.bedelias.services.CursoService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
public class CursoTest {
	
	@Autowired
	private CursoService cursoService;
	
	@Test
	public void test(){
//		UUID code = UUID.randomUUID();
//		Curso curso = new Curso();
//		
//		curso.setCode(code);
//		curso.setName("Plastilina 101 vesp.");
//		curso.setSemestre("Par");
//		curso.setHorario("Los jueves de 9 a 10:30");
//		curso.setFechaInicio(new Date(System.currentTimeMillis()));
//		curso.setFechaFin(new Date(System.currentTimeMillis()));
//		curso.setTurno(TurnoEnum.VESPERTINO);
//		
//		curso = cursoService.createCurso(curso);
//		
//		assertNotNull("Curso can't be null", curso);
//		assertNotNull("Curso Name can't be null", curso.getName());
//		assertNotNull("Curso Code can't be null", curso.getCode());
//		assertNotNull("Curso Semestre can't be null", curso.getSemestre());
//		assertNotNull("Curso Horario can't be null", curso.getHorario());
//		assertNotNull("Curso Fecha Inicio can't be null", curso.getFechaInicio());
//		assertNotNull("Curso Fecha FIn can't be null", curso.getFechaFin());
//		assertNotNull("Curso Turno can't be null", curso.getTurno());
//		
//		assertEquals("Curso Code must be the same", curso.getCode(),
//				code);
	} //FIXME

}

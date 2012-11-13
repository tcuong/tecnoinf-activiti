package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Asignatura;
import edu.bedelias.services.AsignaturaService;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
public class AsignaturaTest {
	
	@Autowired
	private AsignaturaService asignaturaService;
	
	@Test
	public void test(){
//		UUID code = UUID.randomUUID();
//		Asignatura asignatura = new Asignatura();
//
//		asignatura.setName("Platilina 101");
//		asignatura.setCode(code);
//		
//		asignatura = asignaturaService.createAsignatura(asignatura);
//		
//		assertNotNull("Asignatura can't be null", asignatura);
//		assertNotNull("Asignatura Name can't be null", asignatura.getName());
//		assertNotNull("Asignatura Code can't be null", asignatura.getCode());
//		
//		assertEquals("Asignatura Code must be the same", asignatura.getCode(),
//				code);
		
	} // FIXME

}

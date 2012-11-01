package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.entities.Materia;
import edu.bedelias.services.MateriaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
@TransactionConfiguration
@Transactional
public class MateriaTest {
	
	@Autowired
	private MateriaService materiaService;
	
	@Test
	public void test(){
		UUID code = UUID.randomUUID();
		Materia materia = new Materia();
		materia.setName("Didactica");
		materia.setCode(code);
		
		materia = materiaService.createMateria(materia);
		
		assertNotNull("Materia can't be null", materia);
		assertNotNull("Materia Name can't be null", materia.getName());
		assertNotNull("Materia Code can't be null", materia.getCode());
		
		assertEquals("Materia Code must be the same", materia.getCode(),
				code);
	}

}

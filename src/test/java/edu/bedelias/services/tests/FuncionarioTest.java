package edu.bedelias.services.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.entities.Funcionario;
import edu.bedelias.services.FuncionarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest.xml"})
public class FuncionarioTest {
	
	@Autowired
	private FuncionarioService funcService;
	
	@Test
	public void test(){
		
		Funcionario funcionario = new Funcionario();
		funcionario.setName("Chupito");
		funcionario.setEmail("chupame@eltobonia.net");
		funcionario.setCedula("someCedula");
		funcionario.setNumeroFuncionario(123456L);
	
		funcionario = funcService.createFuncionario(funcionario);
		
		assertNotNull("Funcionario can't be null", funcionario);
		assertEquals("Email must be the same", funcionario.getEmail(), "chupame@eltobonia.net");
		
	}

}

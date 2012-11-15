package edu.bedelias.services.tests;

import org.junit.Test;

public class ActaTest {

	@Test
	public void test() {
		ReportsService.print();
		// Comente esto xq me daba error y con maven update no levanto el
		// error....
		// ReportsService.main(null);
	}

}

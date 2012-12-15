package edu.bedelias.tests.services;

import org.junit.Assert;
import org.junit.Test;

import edu.bedelias.utils.SecUtils;

public class SecUtilsTest {

	@Test
	public void test() {

		String pass = SecUtils.hashPassword("Bruno");
		String pass1 = SecUtils.hashPassword("Julio");
		String pass2 = SecUtils.hashPassword("Chirlo");
		String pass3 = SecUtils.hashPassword("Tete");
		String pass4 = SecUtils.hashPassword("PEPEPEP");
		String pass5 = SecUtils.hashPassword("1111111");

		// int i = pass.length()

		pass = pass.substring(pass.length() / 2, pass.length() / 2 + 6);
		pass1 = pass1.substring(pass1.length() / 2, pass1.length() / 2 + 6);
		pass2 = pass2.substring(pass2.length() / 2, pass2.length() / 2 + 6);
		pass3 = pass3.substring(pass3.length() / 2, pass3.length() / 2 + 6);
		pass4 = pass4.substring(pass4.length() / 2, pass4.length() / 2 + 6);
		pass5 = pass5.substring(pass5.length() / 2, pass5.length() / 2 + 6);

		System.out.println(pass);
		System.out.println(pass1);
		System.out.println(pass2);
		System.out.println(pass3);
		System.out.println(pass4);
		System.out.println(pass5);

		Assert.assertTrue(true);

	}

}

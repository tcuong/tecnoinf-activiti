package edu.bedelias.tests.services;

import org.junit.Assert;
import org.junit.Test;

import edu.bedelias.utils.SecUtils;

public class SecUtilsTest {

	@Test
	public void test() {
		
		String pass = SecUtils.hashPassword("Bruno");
		
		Assert.assertTrue(true);
		
	}

}

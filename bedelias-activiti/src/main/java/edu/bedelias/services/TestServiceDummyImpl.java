package edu.bedelias.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "testServiceDummyImpl")
@Transactional(readOnly = true)
public class TestServiceDummyImpl implements TestServiceDummy {

	@Override
	public void run() {
		System.out
				.println("ESTAMO EN EL SERVIZZZ PUTOOOOO, LA PIJA EN EL BALDE!!!!!");
	}

	@Override
	public void run2() {
		System.out
				.println("ESTAMO EN EL SERVIZZZ PUTOOOOO, En la segunda task!!!");

	}

}

package edu.bedelias.services;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "testCallActivitiImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class TestCallActivitiImpl implements Serializable, TestCallActiviti {
	
	private static final long serialVersionUID = 5624310436682623987L;

	@Override
	public void test(){
		System.out.println("hola");
	}

}

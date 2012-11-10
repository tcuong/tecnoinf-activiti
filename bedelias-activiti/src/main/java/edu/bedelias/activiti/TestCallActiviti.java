package edu.bedelias.activiti;

import java.io.Serializable;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="testCallActiviti")
@Transactional(readOnly = true)
public class TestCallActiviti implements Serializable{
	
	public TestCallActiviti(){
	}

	public void test(){
		System.out.println("hola");
	}

}

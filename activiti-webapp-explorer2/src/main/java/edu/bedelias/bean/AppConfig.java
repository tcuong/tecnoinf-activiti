package edu.bedelias.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

import edu.bedelias.repositories.StudentRepository;

@Configuration
@ImportResource("classpath:activiti.cfg.xml")
public class AppConfig {

	@Autowired
	StudentRepository studentRepo;
}

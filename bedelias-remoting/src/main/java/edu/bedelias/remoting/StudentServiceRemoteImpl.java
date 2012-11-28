package edu.bedelias.remoting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceRemoteImpl implements StudentServiceRemote {

	@Autowired
	edu.bedelias.services.StudentService studentService;
	
	@Override
	public boolean existeStudentByCedula(String cedula) {
		return (studentService.findStudentByCedula(cedula) != null);
	}

}

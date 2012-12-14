package edu.bedelias.beans;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import org.activiti.engine.ProcessEngine;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.bedelias.entities.Curso;
import edu.bedelias.entities.PeriodoInscripcion;
import edu.bedelias.entities.Student;
import edu.bedelias.services.CursoService;
import edu.bedelias.services.StudentService;

@ManagedBean
@RequestScoped
public class InscripcionCursoListadoMB extends GenericMB {

	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{cursoServiceImpl}")
	private CursoService cursoService;
	
	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;

	private List<Curso> cursos;
	private long carreraId = 0;
	private Student student;
	private PeriodoInscripcion periodo;

	public InscripcionCursoListadoMB() {
		super();
	}

	@PostConstruct
	public void init() {
		
		if (estaLogueado()) {
			
			carreraId = (Long) this.getFromSession("carrera");
			
			if(carreraId > 0){
				cursos = cursoService.getCursosByCarrearId(carreraId);
				String cedulaEst = getFromSession(this.cedula).toString();
				student = studentService.findStudentByCedula(cedulaEst);
			}
		}
	}

	public void inscribirse(Curso curso) {

		Map<String, Object> datos = new HashMap<String, Object>();
		datos.put("student", student);
		 datos.put("curso", curso);
		datos.put("periodo", periodo);

		ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext(
				"classpath:activiti.cfg.xml");
		ProcessEngine pe = (ProcessEngine) cpx.getBean("processEngine");
		pe.getRuntimeService().startProcessInstanceByKey(
				"inscribirseCursoEstudiante", datos);

	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public CursoService getCursoService() {
		return cursoService;
	}

	public void setCursoService(CursoService cursoService) {
		this.cursoService = cursoService;
	}

	public long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(long carreraId) {
		this.carreraId = carreraId;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public PeriodoInscripcion getPeriodo() {
		return periodo;
	}

	public void setPeriodo(PeriodoInscripcion periodo) {
		this.periodo = periodo;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
	
}

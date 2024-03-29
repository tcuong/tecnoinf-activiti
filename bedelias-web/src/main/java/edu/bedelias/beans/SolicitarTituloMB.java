package edu.bedelias.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import edu.bedelias.entities.Carreer;
import edu.bedelias.entities.Student;
import edu.bedelias.services.InscripcionService;
import edu.bedelias.services.StudentService;

@ManagedBean
@RequestScoped
public class SolicitarTituloMB extends GenericActivitiMB {

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value = "#{inscripcionServiceImpl}")
	private InscripcionService inscripcionService;

	@ManagedProperty(value = "#{studentServiceImpl}")
	private StudentService studentService;

	private List<SelectItem> carrerasListItem;
	private List<Carreer> carreras;
	private String ciEst;
	private long carreraId;
	private Student student;

	public SolicitarTituloMB() {
		super();
	}

	@PostConstruct
	public void init() {

		if (estaLogueado()) {

			ciEst = getFromSession(this.cedula).toString();
			student = studentService.findStudentByCedula(ciEst);

			if (student != null) {
				carreras = inscripcionService.getCarrerasByStudent(student);
				carrerasListItem = new ArrayList<SelectItem>();
				for (Carreer c : carreras) {
					carrerasListItem
							.add(new SelectItem(c.getId(), c.getName()));
				}
			} else {
				sendErrorMessage("Estudiante no encontrado", "No se han encontrado el estudiante con la cédula dada");
			}
		}
	}

	public void solicitar() {

		// ACA ESTA EL CODIGO PARA LLAMAR AL PROCESO

		HashMap<String, Object> datos = new HashMap<>();
		datos.put("carreraId", carreraId);
		datos.put("studentId", student.getId());

		String key = "entregaTitulo";

		instanciarProceso(key, datos);

		this.sendInfoMessage("Información", "Su solicitud se ha enviado, lo notificaremos por email cuando existan cambios.");
	}

	public List<SelectItem> getCarrerasListItem() {
		return carrerasListItem;
	}

	public void setCarrerasListItem(List<SelectItem> carrerasListItem) {
		this.carrerasListItem = carrerasListItem;
	}

	public List<Carreer> getCarreras() {
		return carreras;
	}

	public void setCarreras(List<Carreer> carreras) {
		this.carreras = carreras;
	}

	public long getCarreraId() {
		return carreraId;
	}

	public void setCarreraId(long carreraId) {
		this.carreraId = carreraId;
	}

	public InscripcionService getInscripcionService() {
		return inscripcionService;
	}

	public void setInscripcionService(InscripcionService inscripcionService) {
		this.inscripcionService = inscripcionService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

}

package edu.bedelias.services.tests.activiti.engine;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest-c3p0.xml"})
public class RuntimeServiceTest {

	private static RuntimeService runtimeService;

//	@BeforeClass
//	public static void init() {
//		ProcessEngine processEngine = ProcessEngineConfiguration
//				.createStandaloneInMemProcessEngineConfiguration()
//				.buildProcessEngine();
//		RepositoryService repositoryService = processEngine
//				.getRepositoryService();
//		repositoryService.createDeployment()
//				.addClasspathResource("chapter4/bookorder.bpmn20.xml").deploy();
//		runtimeService = processEngine.getRuntimeService();
//	}
	
	
	@BeforeClass
	public static void init() {
		// Bootstrap
				ProcessEngine processEngine = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml")
					.buildProcessEngine();
	}

	@Ignore
	@Test
	public void startProcessInstance() {
		Map<String, Object> variableMap = new HashMap<String, Object>();
		variableMap.put("isbn", "123456");
		ProcessInstance processInstance = runtimeService
				.startProcessInstanceByKey("bookorder", variableMap);
		assertNotNull(processInstance.getId());
		System.out.println("id " + processInstance.getId() + " "
				+ processInstance.getProcessDefinitionId());
	}

	@Ignore
	@Test
	public void queryProcessInstance() {
		List<ProcessInstance> instanceList = runtimeService
				.createProcessInstanceQuery().processDefinitionKey("bookorder")
				.list();
		for (ProcessInstance queryProcessInstance : instanceList) {
			assertEquals(false, queryProcessInstance.isEnded());
			System.out.println("id " + queryProcessInstance.getId()
					+ ", ended=" + queryProcessInstance.isEnded());
		}
	}

}

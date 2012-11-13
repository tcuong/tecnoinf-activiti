package edu.bedelias.services.tests.activiti.engine;

import java.util.HashMap;

import org.activiti.engine.RuntimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.services.AsignaturaService;
import edu.bedelias.utils.ActivitiUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContextTest-c3p0.xml"})
public class AAEngineTest {

    @Autowired
    private AsignaturaService asignaturaService;

    @Test
    public void test() {

        RuntimeService rs = ActivitiUtil.getRuntimeService();

        rs.startProcessInstanceByKey("testjava1", new HashMap<String, Object>());

    }

}

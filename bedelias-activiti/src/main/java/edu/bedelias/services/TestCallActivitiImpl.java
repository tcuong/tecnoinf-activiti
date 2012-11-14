package edu.bedelias.services;

import java.io.Serializable;
import java.util.HashMap;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.utils.ActivitiUtil;

@Service(value = "testCallActivitiImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class TestCallActivitiImpl implements Serializable, TestCallActiviti {

    private static final long serialVersionUID = 5624310436682623987L;
    private static Logger log = Logger.getLogger(TestCallActiviti.class);

    @Override
    public void test() {
        log.debug("*** Print Something Nice :) ***");

        RuntimeService runtimeService = ActivitiUtil.getRuntimeService();

        // ActivitiRule activitiRule = new ActivitiRule();
        //
        // runtimeService = activitiRule.getRuntimeService();

        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("testjava1",
                new HashMap<String, Object>());
    }

}

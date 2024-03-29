package edu.bedelias.services.impl;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.bedelias.services.TestCallActiviti;

@Service(value = "testCallActivitiImpl")
@Scope(value = "session")
@Transactional(readOnly = true)
public class TestCallActivitiImpl implements Serializable, TestCallActiviti {

    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(TestCallActiviti.class.getName());

    @Override
    public void test() {
        log.debug("*** Print Something Nice :) ***");

    }

}

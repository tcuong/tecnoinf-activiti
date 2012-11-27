package edu.bedelias.remoting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.bedelias.remoting.DateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class DateServiceTest extends ServerRunner {

    @Autowired
    private DateService dateService;

    @Test
    public void testDateService() {
        System.out.println(dateService.getDate());
    }
}
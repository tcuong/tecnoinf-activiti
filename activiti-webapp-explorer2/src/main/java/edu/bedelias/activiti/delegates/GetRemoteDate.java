package edu.bedelias.activiti.delegates;

import java.util.Date;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import edu.bedelias.remote.DateService;

@Component("getRemoteDate")
public class GetRemoteDate implements JavaDelegate {

	private static org.apache.log4j.Logger logger = org.apache.log4j.Logger
			.getLogger(GetRemoteDate.class.getName());

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
				"DateServiceTest-context.xml");

		// instantiate our spring dao object from the application context
		DateService ds = (DateService) ctx.getBean("dateService");

		Date d = ds.getDate();
		logger.trace("==============================================");
		logger.debug("==============================================");
		logger.info("==============================================");
		logger.info("+++ this is the date: :::::::" + d);
		System.out.println(d);
	}

}

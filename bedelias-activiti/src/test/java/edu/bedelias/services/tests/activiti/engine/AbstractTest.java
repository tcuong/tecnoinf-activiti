package edu.bedelias.services.tests.activiti.engine;

import static org.junit.Assert.*;

import java.util.logging.Handler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.activiti.engine.impl.util.LogUtil;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractTest {

	@BeforeClass
	public static void routeLoggingToSlf4j() {
		LogUtil.readJavaUtilLoggingConfigFromClasspath();
		Logger rootLogger = LogManager.getLogManager().getLogger("");
		Handler[] handlers = rootLogger.getHandlers();
		for (int i = 0; i < handlers.length; i++) {
			rootLogger.removeHandler(handlers[i]);
		}
		// SLF4JBridgeHandler.install(); FIXME
	}

}

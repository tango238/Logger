package com.plugram.logger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LoggerContextTest {

	@Test
	public void testGetLogger() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		Logger logger = context.getLogger(Main.class.getName());
		assertThat(logger, is(notNullValue()));
	}
	
}

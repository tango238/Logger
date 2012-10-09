package com.plugram.logger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.plugram.logger.config.DebugConfiguration;
import com.plugram.logger.config.TraceConfiguration;

public class LoggerTest {

	@Test
	public void testTrace() {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new TraceConfiguration());
		Logger logger = context.getLogger(Main.class);
		
		// TODO trace
		assertThat(logger.isTraceEnabled(), is(true));
	}
	
	@Test
	public void testDebug() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new DebugConfiguration());
		Logger logger = context.getLogger(Main.class);

		// TODO debug
		assertThat(logger.isDebugEnabled(), is(true));
	}
	
//	@Test
//	public void testWarn() throws Exception {
//		LoggerContext context = LogManager.getManager().getLoggerContext();
//		Logger logger = context.getLogger(Main.class);
//
//		// TODO warn
//	}
//	
//	@Test
//	public void testError() throws Exception {
//		LoggerContext context = LogManager.getManager().getLoggerContext();
//		
//		
//		Logger logger = context.getLogger(Main.class);
//
//		// TODO error
//	}
//	
//	@Test
//	public void testFatal() throws Exception {
//		LoggerContext context = LogManager.getManager().getLoggerContext();
//		
//		
//		Logger logger = context.getLogger(Main.class);
//
//		// TODO fatal
//	}
}

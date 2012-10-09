package com.plugram.logger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.plugram.logger.config.DebugConfiguration;
import com.plugram.logger.config.ErrorConfiguration;
import com.plugram.logger.config.FatalConfiguration;
import com.plugram.logger.config.TraceConfiguration;
import com.plugram.logger.config.WarnConfiguration;

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
	
	@Test
	public void testWarn() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new WarnConfiguration());
		Logger logger = context.getLogger(Main.class);

		// TODO warn
		assertThat(logger.isWarnEnabled(), is(true));
	}
	
	@Test
	public void testError() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new ErrorConfiguration());		
		Logger logger = context.getLogger(Main.class);

		// TODO error
		assertThat(logger.isErrorEnabled(), is(true));
	}
	
	@Test
	public void testFatal() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new FatalConfiguration());
		Logger logger = context.getLogger(Main.class);

		// TODO fatal
		assertThat(logger.isFatalEnabled(), is(true));
	}
}

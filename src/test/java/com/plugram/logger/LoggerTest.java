package com.plugram.logger;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.plugram.logger.appender.ConsoleAppender;
import com.plugram.logger.config.DebugConfiguration;
import com.plugram.logger.config.ErrorConfiguration;
import com.plugram.logger.config.FatalConfiguration;
import com.plugram.logger.config.InfoConfiguration;
import com.plugram.logger.config.LogLevel;
import com.plugram.logger.config.TraceConfiguration;
import com.plugram.logger.config.WarnConfiguration;

import static com.plugram.logger.ConfigCommands.*;

public class LoggerTest {
	
	@Test
	public void testLogger() throws Exception {
		LoggerContext context = new LoggerFactory(){{
			addLoggerConfig("hoge.aaa.bbb", LogLevel.DEBUG, new ConsoleAppender());
			addLoggerConfig("hoge.bbb.ccc", LogLevel.WARN, new ConsoleAppender());
		}}.getLoggerContext();
		
		Logger logger1 = context.getLogger("hoge.aaa.bbb.Foo");
		assertThat(logger1.isDebugEnabled(), is(true));
		
		Logger logger2 = context.getLogger("hoge.bbb.ccc.Bar");
		assertThat(logger2.isDebugEnabled(), is(false));
		
		// RootLogger: LogLevel.ERROR
		Logger logger3 = context.getLogger("xxx.xxx.Bar");
		assertThat(logger3.isDebugEnabled(), is(false));
		assertThat(logger3.isErrorEnabled(), is(true));
	}
	
	@Test
	public void testFilterByName() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new TraceConfiguration());
		Logger logger = context.getLogger("com.plugram.logger.aaa.Hoge");
		assertThat(logger.isTraceEnabled(), is(true));

		Logger logger2 = context.getLogger("com.plugram.logger.bbb.Foo");
		assertThat(logger2.isTraceEnabled(), is(false));
	}

	@Test
	public void testName() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new TraceConfiguration());
		Logger logger = context.getLogger(LoggerTest.class);
		assertThat(logger.getName(), is(LoggerTest.class.getName()));
	}
	
	@Test
	public void testTrace() {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new TraceConfiguration());
		Logger logger = context.getLogger(Main.class);
		
		// trace
		assertThat(logger.isTraceEnabled(), is(true));
		assertThat(logger.isDebugEnabled(), is(true));
		assertThat(logger.isInfoEnabled(), is(true));
		assertThat(logger.isWarnEnabled(), is(true));
		assertThat(logger.isErrorEnabled(), is(true));
		assertThat(logger.isFatalEnabled(), is(true));
		logger.trace("trace message.");
		logger.debug("debug message.");
		logger.trace("info message.");
		logger.warn("warn message.");
		logger.error("error message.");
		logger.fatal("fatal message.");
	}
	
	@Test
	public void testDebug() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new DebugConfiguration());
		Logger logger = context.getLogger(Main.class);

		// debug
		assertThat(logger.isTraceEnabled(), is(false));
		assertThat(logger.isDebugEnabled(), is(true));
		assertThat(logger.isInfoEnabled(), is(true));
		assertThat(logger.isWarnEnabled(), is(true));
		assertThat(logger.isErrorEnabled(), is(true));
		assertThat(logger.isFatalEnabled(), is(true));
	}
	
	@Test
	public void testInfo() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new InfoConfiguration());
		Logger logger = context.getLogger(Main.class);

		// warn
		assertThat(logger.isTraceEnabled(), is(false));
		assertThat(logger.isDebugEnabled(), is(false));
		assertThat(logger.isInfoEnabled(), is(true));
		assertThat(logger.isWarnEnabled(), is(true));
		assertThat(logger.isErrorEnabled(), is(true));
		assertThat(logger.isFatalEnabled(), is(true));
	}
	
	@Test
	public void testWarn() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new WarnConfiguration());
		Logger logger = context.getLogger(Main.class);

		// warn
		assertThat(logger.isTraceEnabled(), is(false));
		assertThat(logger.isDebugEnabled(), is(false));
		assertThat(logger.isInfoEnabled(), is(false));
		assertThat(logger.isWarnEnabled(), is(true));
		assertThat(logger.isErrorEnabled(), is(true));
		assertThat(logger.isFatalEnabled(), is(true));
	}
	
	@Test
	public void testError() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new ErrorConfiguration());		
		Logger logger = context.getLogger(Main.class);

		// error
		assertThat(logger.isTraceEnabled(), is(false));
		assertThat(logger.isDebugEnabled(), is(false));
		assertThat(logger.isInfoEnabled(), is(false));
		assertThat(logger.isWarnEnabled(), is(false));
		assertThat(logger.isErrorEnabled(), is(true));
		assertThat(logger.isFatalEnabled(), is(true));
	}
	
	@Test
	public void testFatal() throws Exception {
		LoggerContext context = LogManager.getManager().getLoggerContext();
		context.reconfigure(new FatalConfiguration());
		Logger logger = context.getLogger(Main.class);

		// fatal
		assertThat(logger.isTraceEnabled(), is(false));
		assertThat(logger.isDebugEnabled(), is(false));
		assertThat(logger.isWarnEnabled(), is(false));
		assertThat(logger.isErrorEnabled(), is(false));
		assertThat(logger.isFatalEnabled(), is(true));
	}
}

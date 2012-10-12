package com.plugram.logger;

import static com.plugram.logger.ConfigCommands.*;

import com.plugram.logger.appender.ConsoleAppender;
import com.plugram.logger.config.LogLevel;

public class Main {

	static LoggerContext loggerContext = new LoggerFactory(){{
		addLoggerConfig("hoge.aaa.bbb", LogLevel.DEBUG, new ConsoleAppender());
		addLoggerConfig("hoge.bbb.ccc", LogLevel.WARN, new ConsoleAppender());
		addLoggerConfig("hoge.bbb.ccc", LogLevel.WARN, new ConsoleAppender());
		addLoggerConfig("com.plugram.logger", LogLevel.WARN, new ConsoleAppender());
		// TODO bug: addLoggerConfig("com.plugram.logger.Main", LogLevel.ERROR, new ConsoleAppender());
	}}.getLoggerContext();
	
	static Logger logger = loggerContext.getLogger(Main.class);
	
	public static void main(String[] args){
		logger.trace("Trace message");
		logger.debug("Debug message");
		logger.info("Info message");
		logger.warn("Warn message");
		logger.error("Error message");
		logger.fatal("Fatal message");
	}
}

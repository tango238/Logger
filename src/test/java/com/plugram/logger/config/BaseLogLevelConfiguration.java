package com.plugram.logger.config;

import com.plugram.logger.appender.ConsoleAppender;

public class BaseLogLevelConfiguration extends AbstractConfiguration {

	private LogLevel level;
	
	public BaseLogLevelConfiguration(LogLevel level) {
		this.level = level;
	}

	@Override
	public void start() {
		addLoggerConfig("com.plugram.logger.Main", level, new ConsoleAppender());
		addLoggerConfig("com.plugram.logger.LoggerTest", level, new ConsoleAppender());
	}

}

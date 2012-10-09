package com.plugram.logger;

import com.plugram.logger.config.LogLevel;

public class LoggerConfig {

	private final String name;
	
	private final Logger logger;
	
	private final LogLevel level;
	
	public LoggerConfig(String name, LogLevel level) {
		this.name = name;
		this.logger = newInstance();
		this.level = level;
	}

	private Logger newInstance() {
		return new Logger(this);
	}

	public LogLevel getLevel() {
		return level;
	}

	public Logger getLogger() {
		return logger;
	}

	public String getName() {
		return name;
	}

}

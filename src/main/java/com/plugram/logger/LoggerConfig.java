package com.plugram.logger;

import com.plugram.logger.appender.Appender;
import com.plugram.logger.config.LogLevel;

public class LoggerConfig {

	private final String name;
	
	private final Logger logger;
	
	private final LogLevel level;
	
	private final Appender appender;
	
	public LoggerConfig(String name, LogLevel level, Appender appender) {
		this.name = name;
		this.logger = newInstance();
		this.level = level;
		this.appender = appender;
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

	public void log(String msg) {
		appender.write(msg.getBytes());
	}

}

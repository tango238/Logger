package com.plugram.logger;

import com.plugram.logger.config.Configuration;

public class Logger {

	private final String name;
	
	private Configuration config;
	
	private LoggerConfig loggerConfig; 
	
	public Logger(String name, LoggerContext context) {
		this.name = name;
		this.config = context.getConfig();
		this.loggerConfig = config.getLoggerConfig(name);
	}

}

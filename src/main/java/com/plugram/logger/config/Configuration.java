package com.plugram.logger.config;

import com.plugram.logger.LoggerConfig;

public interface Configuration {

	public void start();
	
	public void stop();
	
	public LoggerConfig getLoggerConfig(String name);
	
	public LogLevel getLevel();
	
}

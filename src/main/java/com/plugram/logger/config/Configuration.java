package com.plugram.logger.config;

import java.util.Map;

import com.plugram.logger.LoggerConfig;
import com.plugram.logger.appender.Appender;

public interface Configuration {

	public void start();
	
	public void stop();
	
	public LoggerConfig getLoggerConfig(String name);
	
	public void addAppender(String name, Appender appender);

	public Map<String, Appender> getAppenders();
	
}
